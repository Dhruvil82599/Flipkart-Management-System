package flipkartDao;

import java.sql.SQLException;
import java.util.Scanner;

import Registration.CustomerRegister;

public class CustomerPanel {

	public static void main(String[] args) throws SQLException {

		System.out.println("\n************************************************************");
		System.out.println("                 ⭐ WELCOME TO CUSTOMER PANEL ⭐               ");
		System.out.println("************************************************************");
		System.out.println("\n🔹 Press 1 : Login");
		System.out.println("🔹 Press 2 : Register Customer");
		System.out.println();
		System.out.println("************************************************************\n");

		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			Validation.isCustomerLogin();
			break;

		case 2:
			CustomerRegister.CustomerRegister();
		}

	}

}
