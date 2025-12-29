package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.BankAccount;
import com.raj.service.IBankAccountService;

@Component
public class LocalTransactionManagementTestRunner implements CommandLineRunner {

	@Autowired
	private IBankAccountService accountService;

	@Override
	public void run(String... args) throws Exception {

		try(Scanner sc = new Scanner(System.in)){

			while(true) {

				System.out.println("\n=========== Bank Management System ===========");
				System.out.println("1. Open New Account.");
				System.out.println("2. Deposite Money in Account.");
				System.out.println("3. Withdraw Money from Account.");
				System.out.println("4. Transfer Money To another Account.");
				System.out.println("5. Exit.");

				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {

				case 1:
					System.out.print("Enter Account Holder Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Account Holder Address: ");
					String addrs = sc.nextLine();
					System.out.print("Enter Deposite Amount: ");
					double amt = Double.parseDouble(sc.nextLine());

					BankAccount account = new BankAccount(name, addrs, amt);

					String openBankAccount = accountService.openBankAccount(account);
					System.out.println(openBankAccount);
					break;
				case 2:
					System.out.print("Enter Your Account Number: ");
					Long acno = Long.parseLong(sc.nextLine());

					System.out.print("Enter Deposite Amount: ");
					amt = Double.parseDouble(sc.nextLine());

					String depositeAmount = accountService.depositeAmount(acno, amt);
					System.out.println(depositeAmount);
					break;
				case 3:
					System.out.print("Enter Your Account Number: ");
					acno = Long.parseLong(sc.nextLine());

					System.out.print("Enter Deposite Amount: ");
					amt = Double.parseDouble(sc.nextLine());

					String withdrawAmount = accountService.withdrawAmount(acno, amt);
					System.out.println(withdrawAmount);
					break;
				case 4:
					System.out.print("Enter Source Account Number: ");
					long srcAcno = Long.parseLong(sc.nextLine());
					
					System.out.print("Enter Destination Account Number: ");
					long destAcno = Long.parseLong(sc.nextLine());

					System.out.print("Enter Transfer Amount: ");
					amt = Double.parseDouble(sc.nextLine());
					
					String transferMoney = accountService.transferMoney(srcAcno, destAcno, amt);
					System.out.println(transferMoney);
					break;
				case 5:
					System.exit(0);
				default:
					System.err.println("Invalid Choice...");
				}
			}

		}catch (Exception e) {

			e.printStackTrace();
		}
	}

}
