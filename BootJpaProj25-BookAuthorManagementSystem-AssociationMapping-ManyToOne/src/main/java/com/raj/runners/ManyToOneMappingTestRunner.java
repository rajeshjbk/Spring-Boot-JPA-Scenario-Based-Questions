package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Author;
import com.raj.entity.Book;
import com.raj.service.IBookMgmtService;

@Component
public class ManyToOneMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IBookMgmtService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in);){
			
			while(true) {
				
				System.out.println("================= Book Author Management System ===============");
				
				System.out.println("1. Add Book.");
				System.out.println("2. Show All Books.");
				
				System.out.println("3. Delete Books.");
				
				System.out.println("4. Exit.");
				
				System.out.print("Enetr Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				case 1:
					 // Author Input
			        System.out.print("Enter Author Name: ");
			        String authorName = sc.nextLine();

			        System.out.print("Enter Author Country: ");
			        String country = sc.nextLine();

			        Author author = bookService.saveAuthor(
			                new Author(authorName, country)
			        );

			        // Books Input
			        System.out.print("Enter number of books: ");
			        int count = Integer.parseInt(sc.nextLine());

			        for (int i = 1; i <= count; i++) {
			            System.out.print("Enter Book Title: ");
			            String title = sc.nextLine();

			            System.out.print("Enter Book Genre: ");
			            String genre = sc.nextLine();

			            Book book = new Book(title, genre);
			            
			            book.setAuthor(author);   
			            
			            String saved = bookService.addBook(book);
			            System.out.println(saved);
			        }
					break;
					
				case 2:
					bookService.showAllBooks().forEach(book->{
						
						System.out.println(book);
						Author author2 = book.getAuthor();
						System.out.println(author2);
						
						System.out.println("=================================");
					});
					break;
				case 3:
					System.out.print("Enter Book ID: ");
					int id = Integer.parseInt(sc.nextLine());
					
					String deleteBookById = bookService.deleteBookById(id);
					System.out.println(deleteBookById);
					break;
				case 4:
					System.exit(0);
				default:
					System.err.println("Invalid Choice..");
				}
				
			}
	       
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}

}
