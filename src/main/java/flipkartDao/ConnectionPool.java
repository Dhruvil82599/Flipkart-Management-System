package flipkartDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/flipcart?user=postgres&password=root";
	private static int pool_size = 5;
	static List<Connection> connectionsPool = new ArrayList<>();

	static {
		try {
			Class.forName(driver);
			for (int i = 0; i < pool_size; i++) {
				connectionsPool.add(createConnectionObject());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnectionObject() {
		if (!connectionsPool.isEmpty()) {
			return connectionsPool.remove(0);
		} else {
			return ConnectionPool.createConnectionObject();
		}
	}

	public static void reciveConnectionObject(Connection connection) {
		if (connectionsPool.size() < pool_size) {
			connectionsPool.add(connection);
		} else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	static Connection createConnectionObject() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}