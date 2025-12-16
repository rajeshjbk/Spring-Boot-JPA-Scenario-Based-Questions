package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.document.User;
import com.raj.service.IUserService;

@Component
public class UserTestRunner implements CommandLineRunner {

	@Autowired
	private IUserService userService;
	
	@Override
	public void run(String... args) throws Exception {

       try(Scanner sc = new Scanner(System.in)){
    	   
    	   while(true) {
    		   
    		   System.out.println("\n====== Login And User Validation System ======");
    		   System.out.println("1. Add New User.");
    		   System.out.println("2. Find User by username.");
    		   System.out.println("3. Find User by email.");
    		   System.out.println("4. Check User existance by username.");
    		   System.out.println("5. Check User existance by email.");
    		   System.out.println("6. Exit.");
    		   
    		   
    		   System.out.print("Enter Your choice:");
    		   int choice = Integer.parseInt(sc.nextLine());
    		   
    		   switch(choice) {
    		   
    		   case 1:
    			   System.out.print("Enter User name: ");
    			   String username = sc.nextLine();
    			   System.out.print("Enter User email: ");
    			   String email = sc.nextLine();
    			   System.out.print("Enter User password: ");
    			   String password = sc.nextLine();
    			   System.out.print("Enter User role: ");
    			   String role = sc.nextLine();
    			   System.out.print("Enter User active: ");
    			   Boolean active = Boolean.parseBoolean(sc.nextLine());
    			   
    			   User user = new User(username, email, password, role, active);
    			   
    			   String save = userService.addUser(user);
    			   System.out.println(save);
    			   break;
    			   
    		   case 2:
    			   System.out.print("Enter User name: ");
    			   username = sc.nextLine();
    			   User userByName = userService.findUserByName(username);
    			   System.out.println(userByName);
    			   break;
    			   
    		   case 3:
    			   System.out.print("Enter User email: ");
    			   email = sc.nextLine();
    			   
    			   User userByEmail = userService.findUserByEmail(email);
    			   System.out.println(userByEmail);
    			   break;
    		   case 4:
    			   System.out.print("Enter User name: ");
    			   username = sc.nextLine();
    			   
    			   boolean existByUsername = userService.existsByUsername(username);
    			   System.out.println(existByUsername?"User is exist with username: "+username:"User doesn't exist with this username:"+username);
    			   break;
    		   case 5:
    			   System.out.print("Enter User email: ");
    			   email = sc.nextLine();
    			   
    			   boolean existByEmail = userService.existsByEmail(email);
    			   System.out.println(existByEmail?"User is exist with email: "+email:"User doesn't exist with this email:"+email);
    			   break;
    		   case 6:
    			   System.exit(0);
    			   
    		   }
    	   }
       }catch (Exception e) {
		
    	   e.printStackTrace();
	}

	}

}
