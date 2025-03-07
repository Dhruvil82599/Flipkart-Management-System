package Products;

import java.sql.SQLException;
import java.util.Scanner;

import entity.ProductEntity;
import flipkartDao.Register;

public class ProductRegister {

	public static void AddProduct() throws SQLException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Product id:- ");
		int id = sc.nextInt();

		System.out.println("Enter the Product name:- ");
		String name = sc.next();

		System.out.println("Enter the Product price:- ");
		int price = sc.nextInt();

		ProductEntity entity = new ProductEntity();

		entity.setProduct_id(id);
		entity.setProduct_name(name);
		entity.setProduct_price(price);
		
		Register.productRegister(entity);

	}

}
