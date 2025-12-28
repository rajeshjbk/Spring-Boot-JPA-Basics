package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.raj.document.Customer;
import com.raj.service.ICustomerService;

@Component
public class CustomerTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		
        try(Scanner sc = new Scanner(System.in)){
        	
        	while(true) {
        		System.out.println("====== Customer Management System ======");
        		System.out.println("1. Add New customer.");
        		System.out.println("2. Add Multiple New customer.");
        		System.out.println("3. Show Customer by Bill Amount.");
        		System.out.println("4. Discount on Bill Amounts.");
        		System.out.println("5. Remove Customer by Bill Amounts.");
        		System.out.println("6. Total no.of Customers belongs to Specific Customer Address.");
        		System.out.println("7. Exit.");
        		
        		System.out.print("Enter your Choice: ");
        		int choice = Integer.parseInt(sc.nextLine());
        		
        		switch(choice) {
        		case 1:
        			System.out.print("Enter Customer Name: ");
        			String name = sc.nextLine();
        			System.out.print("Enter Customer Address: ");
        			String addrs = sc.nextLine();
        			System.out.print("Enter Customer Bill Amount: ");
        			Double billAmt = Double.parseDouble(sc.nextLine());
        			
        			Customer customer = new Customer(name, addrs, billAmt);
        			
        			String saveCustomer = customerService.saveCustomer(customer);
        			System.out.println(saveCustomer);
        			break;
        		case 2:
        			System.out.print("How many Customers you want to add: ");
        			int noOfCust = Integer.parseInt(sc.nextLine());
        			List<Customer> list = new ArrayList<Customer>();
        			
        			for(int i=1; i<=noOfCust; i++) {
        				
        				System.out.println("Fill "+i+ " Customer Details.");
        				
        				System.out.print("Enter Customer Name: ");
            			name = sc.nextLine();
            			System.out.print("Enter Customer Address: ");
            			addrs = sc.nextLine();
            			System.out.print("Enter Customer Bill Amount: ");
            			billAmt = Double.parseDouble(sc.nextLine());
            			
            			customer = new Customer(name, addrs, billAmt);
            			list.add(customer);
        			}
        			String saveCustomersBatch = customerService.saveCustomersBatch(list);
        			System.out.println(saveCustomersBatch);
        			break;
        		case 3:
        			System.out.print("Enter minimum Bill Amount: ");
        			Double min = Double.parseDouble(sc.nextLine());
        			
        			System.out.print("Enter maximum Bill Amount: ");
        			Double max = Double.parseDouble(sc.nextLine());
        		
        			List<Customer> showCustomersByBillAmts = customerService.showCustomersByBillAmts(min,max);
        			showCustomersByBillAmts.forEach(System.out::println);
        			break;
        		case 4:
        			System.out.println("Enter Customer address: ");
        			String cAddres = sc.nextLine();
        			
        			System.out.println("Enter Discount % :");
        			Double discountPer = Double.parseDouble(sc.nextLine());
        			
        			String discountBillAmount = customerService.discountBillAmount(cAddres, discountPer);
        			System.out.println(discountBillAmount);
        			break;
        		case 5:
        			System.out.print("Enter minimum Bill Amount: ");
        			min = Double.parseDouble(sc.nextLine());

        			System.out.print("Enter maximum Bill Amount: ");
        			max = Double.parseDouble(sc.nextLine());
        			
        			String removeCustomersByBillAmounts = customerService.removeCustomersByBillAmounts(min, max);
        			System.out.println(removeCustomersByBillAmounts);
        			break;
        			
        		case 6:
        			System.out.print("Enter Customer address: ");
        			cAddres = sc.nextLine();
        			
        			long showCustomersCount = customerService.showCustomersCount(cAddres);
        			System.out.println("Total Customer belongs to "+cAddres+" : "+showCustomersCount);
        			break;
        			
        		case 7:
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
