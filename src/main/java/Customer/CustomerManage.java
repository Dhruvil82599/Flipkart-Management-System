package Customer;

import java.sql.SQLException;
import java.util.Scanner;

import entity.CustomerEntity;
import flipkartDao.Register;

public class CustomerManage {
	
	public static void CustomerRegister() throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                                              ║");
		System.out.println("║  🌟 WELCOME TO CUSTOMER REGISTRATION PAGE 🌟  ║");
		System.out.println("║                                              ║");
		System.out.println("╚══════════════════════════════════════════════╝");
		System.out.println();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Your Id");
		int id = sc.nextInt();

		System.out.println("Enter Your Name:- ");
		String name = sc.next();

		System.out.println("Enter Your Email:- ");
		String email = sc.next();

		System.out.println("Enter Your Mobile Number:- ");
		Long mobile = sc.nextLong();

		System.out.println("Enter Your City:- ");
		String city = sc.next();

		System.out.println("Enter Your Password:- ");
		String password = sc.next();

		CustomerEntity entity = new CustomerEntity();

		entity.setCust_id(id);
		entity.setName(name);
		entity.setEmail(email);
		entity.setPhone_no(mobile);
		entity.setLocation(city);
		entity.setPassword(password);

		Register.CustomerRegister(entity);
	}
}
