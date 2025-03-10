package flipkartDao;

import java.sql.SQLException;
import java.util.Scanner;

import Customer.CustomerManage;
import Products.DeleteProduct;
import Products.ListOfProduct;
import Products.ProductRegister;
import Products.UpdateProduct;

public class AdminPanel {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true; // Control flag for loop

        while (isRunning) {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║                                              ║");
            System.out.println("║        🌟 WELCOME TO ADMIN PANEL 🌟           ║");
            System.out.println("║                                              ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println();

            System.out.println("Press 1 :- Add Product");
            System.out.println("Press 2 :- Update Product");
            System.out.println("Press 3 :- Delete Product");
            System.out.println("Press 4 :- List Of All Products");
            System.out.println("Press 5 :- List Of All Available Customers");
            System.out.println("Press 6 :- Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println(); // For spacing

            switch (choice) {
                case 1:
                    System.out.println("🟢 Add Product:");
                    ProductRegister.AddProduct();
                    break;
                case 2:
                    System.out.println("🟡 Update Product:");
                    UpdateProduct.main(null);
                    break;
                case 3:
                    System.out.println("🔴 Delete Product:");
                    DeleteProduct.main(null);
                    break;
                case 4:
                    System.out.println("📋 List Of All Available Products:");
                    ListOfProduct.main(null);
                    break;
                case 5:
                    System.out.println("👥 List Of All Available Customers:");
                    CustomerManage.ListOfCustomer();
                    break;
                case 6:
                    System.out.println("🚪 Exiting Admin Panel... Goodbye!");
                    isRunning = false; // Set flag to false to exit loop
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

            System.out.println(); // Add space before next menu display
        }

        sc.close(); // Close scanner
    }
}
