package Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import flipkartDao.ConnectionPool;

public class ListOfProduct {
    public static void main(String[] args) {
        String query = "SELECT * FROM flipkart_product";

        // Using try-with-resources for automatic resource management
        try (Connection connection = ConnectionPool.getConnectionObject();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet set = statement.executeQuery()) {

            System.out.println("═══════════════════════════════════════════");
            System.out.printf("%-12s %-20s %-10s%n", "Product ID", "Product Name", "Price");
            System.out.println("═══════════════════════════════════════════");

            boolean hasProducts = false;

            while (set.next()) {
                hasProducts = true;
                int id = set.getInt(1);
                String name = set.getString(2);
                int price = set.getInt(3);

                System.out.printf("%-12d %-20s %-10d%n", id, name, price);
            }

            if (!hasProducts) {
                System.out.println("⚠️ No products found in the database.");
            }

            System.out.println("═══════════════════════════════════════════");

        } catch (SQLException e) {
            System.out.println("❌ Error fetching product list: " + e.getMessage());
        }
    }
}
