package flipkartDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.CustomerEntity;
import entity.ProductEntity;

public class Register {

    public static void CustomerRegister(CustomerEntity entity) throws SQLException {
        // TODO Auto-generated method stub

        Connection connection = ConnectionPool.createConnectionObject();

        String insert = "insert into flipkart_customer values(?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(insert);

        statement.setInt(1, entity.getCust_id());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getEmail());
        statement.setLong(4, entity.getPhone_no());
        statement.setString(5, entity.getLocation());
        statement.setString(6, entity.getPassword());

        int i = statement.executeUpdate();

        if (i > 0) {
            System.out.println("Customer Register Successfully...");
            System.err.println("Please Login...");

        } else {
            System.out.println("Please Try Again");
        }

        statement.close();
        ConnectionPool.reciveConnectionObject(connection);
    }

    // ***************** Product Register Logic For Batabase *****************
    public static void productRegister(ProductEntity entity) throws SQLException {
        // TODO Auto-generated method stub

        Connection connection = ConnectionPool.createConnectionObject();

        String insert = "insert into flipkart_product values(?,?,?)";

        PreparedStatement statement = connection.prepareStatement(insert);

        statement.setInt(1, entity.getProduct_id());
        statement.setString(2, entity.getProduct_name());
        statement.setInt(3, entity.getProduct_price());

        int i = statement.executeUpdate();

        if (i > 0) {
            System.out.println("Product Register Successfully...");
            AdminPanel.main(null);
        } else {
            System.out.println("Please Try Again");
        }
    }

}
