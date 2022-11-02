package TestVagrantAssignment;

import org.apache.juneau.annotation.Beanc;

public class POJOClass {
	

	private String Name;
	private String Country;
	private String role;
	private String price;

	public POJOClass() {
		super();
			}
	@Beanc(properties ="name, country, role, price-in-crores")
	public POJOClass(String Name, String country, String role, String price) {
		
		this.Name = Name;
		this.Country = country;
		this.role = role;
		this.price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
