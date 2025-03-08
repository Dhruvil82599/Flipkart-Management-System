package Products;

import java.sql.SQLException;
import java.util.Scanner;

import entity.ProductEntity;
import flipkartDao.Register;

public class ProductRegister {

    public static void AddProduct() throws SQLException {
        // Using try-with-resources to ensure Scanner is closed properly
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the Product ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline character to prevent input skipping

            System.out.print("Enter the Product Name: ");
            String name = sc.nextLine().trim(); // Trim to remove leading/trailing spaces

            System.out.print("Enter the Product Price: ");
            int price = sc.nextInt();

            // Creating and setting product entity
            ProductEntity entity = new ProductEntity();
            entity.setProduct_id(id);
            entity.setProduct_name(name);
            entity.setProduct_price(price);

            // Registering product with exception handling
            try {
                Register.productRegister(entity);
                System.out.println("✅ Product registered successfully!");
            } catch (SQLException e) {
                System.out.println("❌ Error registering product: " + e.getMessage());
                throw e;
            }
        }
    }
}
