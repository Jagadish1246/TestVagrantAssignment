# TestVagrantAssignment

# Create the File with extenstion .json in which contain the Json Data 

 [
    {
      "name": "Faf Du Plessis",
      "country": "South Africa",
      "role": "Batsman",
      "price-in-crores": "7"
    },
    {
      "name": "Virat Kohli",
      "country": "India",
      "role": "Batsman",
      "price-in-crores": "15"
    },
    {
      "name": "Glenn Maxwell",
      "country": "Australia",
      "role": "Batsman",
      "price-in-crores": "11"
    },
    {
      "name": "Mohammad Siraj",
      "country": "India",
      "role": "Bowler",
      "price-in-crores": "7"
    },
    {
      "name": "Harshal Patel",
      "country": "India",
      "role": "Bowler",
      "price-in-crores": "10.75"
    },
    {
      "name": "Wanindu Hasaranga",
      "country": "Srilanka",
      "role": "Bowler",
      "price-in-crores": "10.75"
    },
    {
      "name": "Dinesh Karthik",
      "country": "India",
      "role": "Wicket-keeper",
      "price-in-crores": "5.5"
    },
    {
      "name": "Shahbaz Ahmed",
      "country": "India",
      "role": "All-Rounder",
      "price-in-crores": "2.4"
    },
    {
      "name": "Rajat Patidar",
      "country": "India",
      "role": "Batsman",
      "price-in-crores": "0.20"
    },
    {
      "name": "Josh Hazlewood",
      "country": "Australia",
      "role": "Bowler",
      "price-in-crores": "7.75"
    },
    {
      "name": "Mahipal Lomror",
      "country": "India",
      "role": "Bowler",
      "price-in-crores": "7.75"
    }
  ]
  
  # Crate the Pojo class it is fully in capsulated class so we can not access the data of this class in to the another class. Once create the class then 
  crate the variable which is in json data. then Crate the Constructor and innitializa this variable. This calss is fully in capsulated so if we want to access the data 
  in another class for that we create getter and setter method for each variable. The setter Method is Used for set the value of variable and getter method is used for 
  get the value of this variable in another calss
  
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
  
  
  # To access the json data here we user the ObjectMapper 1st we crate the ObjectMapper then By using this we perform the Deserialization thatmeans convert the json data in to 
  java object then crate the array of the pojo class and pass this data to this aaray. Then Create two method for validate the the players 1) validateForigenPlyaers, 2) validateWiketKiper
  
  package TestVagrantAssignment;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import org.apache.juneau.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateTestCases {

	int indianPlayercount = 0;
	int forigenplayercount = 0;
	int WicketKiper = 0;
	POJOClass[] pract;
	LinkedHashMap<String, String> map;

	@BeforeClass
	public void getplayersData() throws JsonParseException, JsonMappingException, IOException, ParseException {
		map = new LinkedHashMap();
		File jsonVal = new File(
				"C:\\Users\\J P\\eclipse-workspace\\TestVagrant.com\\src\\test\\java\\TestVagrantAssignment\\JSONData.json");
		ObjectMapper objmap = new ObjectMapper();
		objmap.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		pract = objmap.readValue(jsonVal, POJOClass[].class);

	}
	

	@Test(priority = 1)
	public void validateForigenPlyaers() {
		for (int i = 0; i < pract.length; i++) {
			map.put("Country", pract[i].getCountry());
			if (map.containsValue("India")) {
				System.out.println();
				indianPlayercount++;
			}

			else {
				forigenplayercount++;

			}
		}
		Assert.assertEquals(forigenplayercount, 4);
		System.out.println("Test Case Is Pass");
	}
	
	

	@Test(priority = 2)
	public void validateWiketKiper() {
		for (int i = 0; i < pract.length; i++) {
			map.put("Role", pract[i].getRole());
			if (map.containsValue("Wicket-keeper")) {
				WicketKiper++;
			}

		}
		Assert.assertEquals(WicketKiper, 1);
		System.out.println("Test Case Is Pass");
	}

}

  
  
  

}
