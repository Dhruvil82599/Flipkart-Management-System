package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entity.CustomerEntity;
import flipkartDao.ConnectionPool;
import flipkartDao.CustomerPanel;
import flipkartDao.Register;

public class CustomerManage {

	public static void CustomerRegister() throws SQLException {
		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                                              ║");
		System.out.println("║  🌟 WELCOME TO CUSTOMER REGISTRATION PAGE 🌟  ║");
		System.out.println("║                                              ║");
		System.out.println("╚══════════════════════════════════════════════╝");
		System.out.println();

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Your ID: ");
			int id = sc.nextInt();
			sc.nextLine(); // Consume the newline character

			System.out.print("Enter Your Name: ");
			String name = sc.nextLine().trim();

			System.out.print("Enter Your Email: ");
			String email = sc.nextLine().trim();

			System.out.print("Enter Your Mobile Number: ");
			long mobile = sc.nextLong();
			sc.nextLine(); // Consume the newline character

			System.out.print("Enter Your City: ");
			String city = sc.nextLine().trim();

			System.out.print("Enter Your Password: ");
			String password = sc.nextLine().trim();

			// Creating and setting customer entity
			CustomerEntity entity = new CustomerEntity();
			entity.setCust_id(id);
			entity.setName(name);
			entity.setEmail(email);
			entity.setPhone_no(mobile);
			entity.setLocation(city);
			entity.setPassword(password);

			try {
				Register.CustomerRegister(entity);
				System.out.println("✅ Customer registered successfully!");
			} catch (SQLException e) {
				System.out.println("❌ Error registering customer: " + e.getMessage());
				throw e;
			}
		}
	}

	public static void ListOfCustomer() throws SQLException {
		String query = "SELECT * FROM flipkart_customer";

		Connection connection = ConnectionPool.getConnectionObject();

		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet set = statement.executeQuery();
		{

			System.out.println(
					"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
			System.out.printf("%-12s %-20s %-25s %-15s %-15s %-15s%n", "Customer ID", "Customer Name", "Customer Email",
					"Mobile Number", "City", "Password");
			System.out.println(
					"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");

			boolean hasCustomers = false;

			while (set.next()) {
				hasCustomers = true;
				int id = set.getInt(1);
				String name = set.getString(2);
				String email = set.getString(3);
				long mobile = set.getLong(4);
				String city = set.getString(5);
				String password = set.getString(6);

				System.out.printf("%-12d %-20s %-25s %-15d %-15s %-15s%n", id, name, email, mobile, city, password);
			}

			if (!hasCustomers) {
				System.out.println("⚠️ No customers found in the database.");
			}

			System.out.println(
					"═════════════════════════════════════════════════════════════════════════════════════════════════");

			System.out.println("❌ Error fetching customer list: ");
		}
		ConnectionPool.reciveConnectionObject(connection);
	}

	public static void DeleteCustomer() throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("Delete Customer");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer Id :- ");

		int CustomerId = sc.nextInt();

		Connection connection = ConnectionPool.getConnectionObject();

		String query = "DELETE FROM flipkart_customer WHERE customer_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, CustomerId);

			int rows = statement.executeUpdate();

			if (rows > 0) {
				System.out.println("Customer Deleted Successfully");
			} else {
				System.out.println("Customer Not Deleted");
			}
		} catch (SQLException e) {
			System.out.println("❌ Error deleting customer: " + e.getMessage());
		}

		ConnectionPool.reciveConnectionObject(connection);
		sc.close();
		CustomerPanel.main(null);

	}
}
