package flipkartDao;

import java.sql.SQLException;
import java.util.Scanner;

import Customer.CustomerManage;
import Flipkart.Flipkart;
import Products.ListOfProduct;
import Products.ProductRegister;
import Products.UpdateProduct;

public class AdminPanel {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
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
            
            System.out.print("Enter your choice:- ");
            System.out.println();
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    ProductRegister.AddProduct();
                    break;
                case 2:
                    // Implement update product functionality
                    System.out.println("Update product functionality not implemented yet.");
                    UpdateProduct.main(null);
                    break;
                case 3:
                    // Implement delete product functionality
                    System.out.println("Delete product functionality not implemented yet.");
                    break;
                case 4:
                    ListOfProduct.main(null);
                    break;
                case 5:
                    CustomerManage.ListOfCustomer();
                    break;
                case 6:
                    System.out.println("Exiting Admin Panel... Goodbye!");
                    Flipkart.main(null);
                    sc.close();
                    return;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }
}
