package entity;

public class CustomerEntity {

	private int Cust_id;
	private String Name;
	private String Email;
	private Long Phone_no;
	private String Location;
	private String Password;

	public int getCust_id() {
		return Cust_id;
	}

	public void setCust_id(int cust_id) {
		this.Cust_id = cust_id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Long getPhone_no() {
		return Phone_no;
	}

	public void setPhone_no(Long phone_no) {
		Phone_no = phone_no;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}


}
