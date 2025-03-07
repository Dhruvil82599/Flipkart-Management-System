package Flipkart;

import java.sql.SQLException;
import java.util.Scanner;

import flipkartDao.CustomerPanel;
import flipkartDao.Validation;

public class Flipkart {

	public static void main(String[] args) throws SQLException {

		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                                              ║");
		System.out.println("║       🌟 WELCOME TO FLIPKART SHOPPING 🌟      ║");
		System.out.println("║                                              ║");
		System.out.println("╚════════════════════════════════════=═════════╝");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		System.out.println("🔹 1️  Admin Panel");
		System.out.println("🔹 2️  Customer Panel");
		System.out.println("🔹 0️  Exit");
		System.out.println();

		System.out.print("👉 Select Your Choice: ");
		int choice = sc.nextInt();

		a: while (true) {
			switch (choice) {
			case 1:
				System.out.println("\n🛠️  Redirecting to Admin Panel...\n");
				Validation.IsAdminValid();
				break;

			case 2:
				System.out.println("\n🛒  Redirecting to Customer Panel...\n");
				CustomerPanel.main(null);
				break;

			case 0:
				System.out.println("\n❌ Exiting Flipkart. Thank you for visiting! 😊");
				sc.close();
				break a;

			default:
				System.out.println("\n⚠️ Invalid choice! Please select a valid option.\n");
			}
		}
	}
}
