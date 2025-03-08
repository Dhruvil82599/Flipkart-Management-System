package Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import flipkartDao.ConnectionPool;

public class UpdateProduct {

	public static void main(Object object) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("Update Product ");

		System.out.print("Press 1 :- Update Product Name");
		System.out.print("Press 2 :- Update Product Price");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			UpdateProduct.UpdateProductName();
			break;
		case 2:
			UpdateProduct.UpdateProductPrice();
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}

	// Update Product Name Using Product Id

	private static void UpdateProductName() throws SQLException {

		Connection connection = ConnectionPool.getConnectionObject();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Product Name :- ");
		String ProductName = sc.next();

		System.out.print("Enter Product Id :- ");
		int ProductId = sc.nextInt();
		String query = "UPDATE flipkart_product SET product_name = ? WHERE product_id = ?";

		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, ProductName);
		statement.setInt(2, ProductId);

		int rows = statement.executeUpdate();

		if (rows > 0) {
			System.out.println("Product Name Updated Successfully");
		} else {
			System.out.println("Product Name Not Updated");
		}
		sc.close();
	}

	// Update Product Price Using Product Id

	private static void UpdateProductPrice() {
		// TODO Auto-generated method stub

		Connection connection = ConnectionPool.getConnectionObject();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Price");
		int ProductPrice = sc.nextInt();

		System.out.println("Enter Product Id");
		int ProductId = sc.nextInt();

		String query = "UPDATE flipkart_product SET product_price = ? WHERE product_id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, ProductPrice);
			statement.setInt(2, ProductId);

			int rows = statement.executeUpdate();

			if (rows > 0) {
				System.out.println("Product Price Updated Successfully");
			} else {
				System.out.println("Product Price Not Updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
