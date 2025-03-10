package Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import flipkartDao.ConnectionPool;

public class DeleteProduct {

	public static void main(String[] args) throws SQLException {
		// Implement delete product functionality
		System.out.println("Delete Product");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Product Id :- ");

		int ProductId = sc.nextInt();

		// Implement delete product functionality

		Connection connection = ConnectionPool.getConnectionObject();
		String query = "DELETE FROM flipkart_product WHERE product_id = ?";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, ProductId);

		int rows = statement.executeUpdate();

		if (rows > 0) {
			System.out.println("Product Deleted Successfully");
		} else {
			System.out.println("Product Not Deleted");
		}

		sc.close();

	}
}
