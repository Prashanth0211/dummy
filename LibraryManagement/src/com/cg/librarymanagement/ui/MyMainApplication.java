package com.cg.librarymanagement.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.cg.librarymanagement.dto.LibraryManagementDto;
import com.cg.librarymanagement.exception.LibraryManagementException;
import com.cg.librarymanagement.service.ILibraryManagementService;
import com.cg.librarymanagement.service.LibraryManagementServiceImpl;

public class MyMainApplication {

	public static void main(String[] args) throws LibraryManagementException {
		// TODO Auto-generated method stub
		ILibraryManagementService service = new LibraryManagementServiceImpl();
		int choice = 0;

		boolean error = false;
		String money;
		String ch;
		do {
			System.out.println("1.view member details");
			System.out.println("2. pay amount");
			System.out.println("3.get all students");
			System.out.println("4.Exit");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("selected to view member details");

				System.out.println("enter the id:");
				String id = sc.next();
				try {
					error = service.validateId(id);
				} catch (LibraryManagementException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				if (error) {
					LibraryManagementDto details = service.viewDetails(id);
					if (details != null) {
						System.out.println("ID of student is: " + details.getId());
						System.out.println("Name of student is: " + details.getName());
						System.out.println("Amount of student is: " + details.getAmount());
					} else {
						System.out.println("enter correct id and try again");
					}

				}
				break;
			case 2:
				System.out.println("enter student id :");
				String id1 = sc.next();
				try {
					error = service.validateId(id1);
				
				if (error) {
					System.out.println("enter the amount to pay:");
					money = sc.next();
					
						error = service.validateMoney(money);
					

					if (error) {
						
							LibraryManagementDto details1 = service.payAmount(id1, money);
							
								System.out.println("ID of student is: " + details1.getId());
								System.out.println("Name of student is: " + details1.getName());
								System.out.println("Amount of student is: " + details1.getAmount());
							
			

						
					}
				}
				 else {
					System.out.println("Student id Not Found ......");
				}
					
				}
				catch(LibraryManagementException l)
				{
					System.out.println(l.getMessage());
				}
			
		
				break;
			case 3:
				System.out.println("You have selected to view all details of students: ");
				HashMap<String, LibraryManagementDto> result = service.viewAll();
				Set<Entry<String, LibraryManagementDto>> set = result.entrySet();
				Iterator<Entry<String, LibraryManagementDto>> it = set.iterator();
				while (it.hasNext()) {
					Map.Entry<String, LibraryManagementDto> entry = it.next();
					String id11 = entry.getKey();
					LibraryManagementDto dto = entry.getValue();
					System.out.println("ID of student is: " + dto.getId());
					System.out.println("Name of student is: " + dto.getName());
					System.out.println("Amount of student is: " + dto.getAmount());

				}
				break;

			case 4:
				System.out.println("thankyou for using");
				System.exit(0);
				break;
			default:
				System.out.println("enter correct value");

			}
			System.out.println("enter y or yes to continue and n or no to exit");
			ch = sc.next();
		} while ((ch.equalsIgnoreCase("y")) || ch.equalsIgnoreCase("yes"));

	}

}
