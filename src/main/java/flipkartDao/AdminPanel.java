package flipkartDao;

import java.sql.SQLException;
import java.util.Scanner;

import Products.ListOfProduct;
import Products.ProductRegister;

public class AdminPanel {

	public static void main() throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                                              ║");
		System.out.println("║        🌟 WELCOME TO ADMIN PANEL 🌟           ║");
		System.out.println("║                                              ║");
		System.out.println("╚══════════════════════════════════════════════╝");
		System.out.println();

		System.out.println("Press 1 :- Add Product");
		System.out.println("Press 2 :- Update Product");
		System.out.println("Press 3 :- Delete Product");
		System.out.println("Press 4 :- List Of All Product ");
		System.out.println("Press 5 :- List Of All Available Customer");
		System.out.println("Press 6 :- Exit");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		a: switch (choice) {

		case 1:
			ProductRegister.AddProduct();
			break;

		case 2:

			break;

		case 3:
			break;

		case 4:
			ListOfProduct.
			break;

		case 5:

			break;

		case 6:

			break a;

		default:
			System.out.println("You Have to entered valid Choice");
		}
	}
}
