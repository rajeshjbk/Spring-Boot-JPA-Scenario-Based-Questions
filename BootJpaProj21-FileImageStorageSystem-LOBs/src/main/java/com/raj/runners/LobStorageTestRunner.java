package com.raj.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.FileRecord;
import com.raj.service.IFileRecordMgmtService;

@Component
public class LobStorageTestRunner implements CommandLineRunner {

	@Autowired
	private IFileRecordMgmtService fileRecordMgmtService;

	@Override
	public void run(String... args) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {

			while (true) {

				System.out.println("\n======== File Storage Management System ==========");
				System.out.println("1. Save New File Record");
				System.out.println("2. Get File Record by Id");
				System.out.println("3. Show All File Records");
				System.out.println("4. Exit");

				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {

				case 1:
					System.out.print("Enter File Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Txt File Path: ");
					String txtPath = sc.nextLine();

					System.out.print("Enter Image File Path: ");
					String imagePath = sc.nextLine();

					String txtContent;
					byte[] imageContent;

					try (FileInputStream fis = new FileInputStream(imagePath);
							FileReader reader = new FileReader(txtPath)) {

						// Image → byte[]
						imageContent = fis.readAllBytes();

						// Text file → String
						File file = new File(txtPath);
						char[] chars = new char[(int) file.length()];
						reader.read(chars);
						txtContent = new String(chars);

					}

					// Call Service
					FileRecord record = new FileRecord(name, txtContent, imageContent);
					String saveFileRecord = fileRecordMgmtService.saveFileRecord(record);
					System.out.println(saveFileRecord);
					break;

				case 2:
					try(FileOutputStream fos = new FileOutputStream("retrive_image.jpg");
							FileWriter writer = new FileWriter("retrive_text.txt");){

						System.out.print("Enter File Record ID: ");
						long id = Long.parseLong(sc.nextLine());

						FileRecord recordById = fileRecordMgmtService.getFileRecordById(id);

						System.out.println("File Records are :: ID: "+recordById.getId()+" File Name: "+recordById.getFileName());

						imageContent = recordById.getFileImage();
						txtContent = recordById.getFileText();

						fos.write(imageContent);
						writer.write(txtContent);

						System.out.println("LOBs are Retrived..");

					}catch (Exception e1) {

						e1.printStackTrace();
					}

					break;

				case 3:
					
					fileRecordMgmtService.showAllFileRecords().forEach(result -> {

						String imageFilePath = "img_" + result.getId() + ".jpg";
						String textFilePath  =	"text_" + result.getId() + ".txt";

						try (FileOutputStream fos = new FileOutputStream(imageFilePath);
								FileWriter writer = new FileWriter(textFilePath);) {

							// Write BLOB
							fos.write(result.getFileImage());

							// Write CLOB
							writer.write(result.getFileText());


							System.out.println(
									"Retrieved -> ID: " + result.getId() +
									", Image saved at: " + imageFilePath +
									", Text saved at: " + textFilePath
									);


						} catch (Exception e1) {

							e1.printStackTrace();
						}
					});

					System.out.println("=== All LOB Records Retrieved into Project Directory ===");
					break;

				case 4:
					System.exit(0);

				default:
					System.out.println("Invalid Choice! Try Again.");
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
