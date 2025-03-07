package flipkartDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Validation {

	public static void IsAdminValid() throws SQLException {

		System.out.println("******************** 🌟 Admin Panel ********************");

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Admin Id :- ");
		int admin_id = sc.nextInt();

		System.out.print("Enter Admin Password :- ");
		String admin_pass = sc.next();

		Connection connection = ConnectionPool.getConnectionObject();

		String query = "SELECT adminisvalid(?, ?)"; // Calling function that returns a result

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, admin_id);
		statement.setString(2, admin_pass);

		// Use executeQuery() instead of executeUpdate()
		ResultSet rs = statement.executeQuery();

		// Check if result exists and process it
		if (rs.next()) {
			boolean isValid = rs.getBoolean(1);
			if (isValid) {
				System.out.println("Admin login Successfully...");
				AdminPanel.main();
			} else {
				System.out.println("Please Check Your id Or Password");
				Validation.IsAdminValid();
			}
		}
		// Close resources
		rs.close();
		statement.close();
		ConnectionPool.reciveConnectionObject(connection);

		sc.close();
	}

	public static void isCustomerLogin() throws SQLException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Customer Login");

		System.out.println("Enter Customer Id");
		int id = sc.nextInt();

		System.out.println("Enter Customer Password");
		String password = sc.next();

		Connection connection = ConnectionPool.getConnectionObject();

		String valid = "select customerisvalid(?,?)";

		PreparedStatement statement = connection.prepareStatement(valid);

		statement.setInt(1, id);
		statement.setString(2, password);

		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			boolean isvalid = rs.getBoolean(1);
			if (isvalid) {
				System.out.println("Flipkart Login Successfully...");
			} else {
				System.out.println("Please Check Your Id Or Password...");
			}
		}

	}

}
