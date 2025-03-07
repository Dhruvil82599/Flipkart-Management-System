package Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import flipkartDao.ConnectionPool;

public class ListOfProduct {
	public static void main(String[] args) throws SQLException {

		Connection connection = ConnectionPool.getConnectionObject();

		String query = "select * from flipkart_product";

		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet set = statement.executeQuery();

		System.out.println("Product ID\tProduct Name\tProduct Price\t");

		while(set.next()){
			set.getInt(1);
			set.getString(2);
			set.getInt(3);
			System.out.println(set.getInt(1) + "\t\t" + set.getString(2) + "\t\t" + set.getInt(3));
		}
	}

}
