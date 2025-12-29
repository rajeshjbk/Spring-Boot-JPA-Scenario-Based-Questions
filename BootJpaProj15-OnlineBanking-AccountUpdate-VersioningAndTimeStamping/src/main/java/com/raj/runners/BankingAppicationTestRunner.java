package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Account;
import com.raj.service.IAccountService;

@Component
public class BankingAppicationTestRunner implements CommandLineRunner {

	@Autowired
	private IAccountService accountService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
		
			while(true) {
				
				System.out.println("============= Bank Management System =============");
				System.out.println("1. Open new Account.");
				System.out.println("2. Deposite Amount in Account.");
				System.out.println("3. Withdraw Amount from Account.");
				System.out.println("4. Transfer Money to Another Account.");
				System.out.println("5. Exit.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Your Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Your Address: ");
					String addrs = sc.nextLine();
					System.out.print("Enter Amount: ");
					double amt = Double.parseDouble(sc.nextLine());
					
					Account account = new Account(name, addrs, amt);
					
					String openAccount = accountService.openAccount(account);
					System.out.println(openAccount);
					break;
				case 2:
					System.out.print("Enter Account Number: ");
					int acno = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Deposite Amount: ");
					amt = Double.parseDouble(sc.nextLine());
					
					String depositeMoney = accountService.depositeMoney(acno, amt);
					System.out.println(depositeMoney);
					break;
				case 3:
					System.out.print("Enter Account Number: ");
					acno = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Withdraw Amount: ");
					amt = Double.parseDouble(sc.nextLine());
					
					String withdrawMoney = accountService.withdrawMoney(acno, amt);
					System.out.println(withdrawMoney);
					break;
				case 4:
					System.out.print("Enter Source Account Number: ");
					int srcAcc = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Destination Account Number: ");
					int destAcc = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter transfer Amount: ");
					amt = Double.parseDouble(sc.nextLine());
					
				    String transferMoney = accountService.transferMoney(srcAcc, destAcc, amt);
					System.out.println(transferMoney);
				    break;
				case 5:
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
