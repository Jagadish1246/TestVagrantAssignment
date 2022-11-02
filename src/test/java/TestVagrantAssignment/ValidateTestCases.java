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
	File jsonVal = new File("C:\\Users\\J P\\eclipse-workspace\\TestVagrant.com\\src\\test\\java\\TestVagrantAssignment\\JSONData.json");
	ObjectMapper objmap = new ObjectMapper();
	objmap.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY,true);
	objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	pract = objmap.readValue(jsonVal, POJOClass[].class);

}

	@Test(priority=1)
	public void validateForigenPlyaers() {
	for(int i=0;i<pract.length;i++) {
		map.put("Country", pract[i].getCountry());
		if(map.containsValue("India")) {
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
