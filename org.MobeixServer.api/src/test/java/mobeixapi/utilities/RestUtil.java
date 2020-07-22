package mobeixapi.utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {

	public static String merchantName() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return (generatedString);
	}
	
	public static String contactEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return (generatedString+"mobeix@tagitmobile.com");
	}
	
	public static String contactPhone() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}
	
	public static String contactName() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	
	public static String createdBy() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
	public static String contactAddress() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString+"_ADDRESS");
	}
	
	public static String productCategory() {
		String generatedString = RandomStringUtils.randomNumeric(1);
		return (generatedString);
	}
	
	public static String registrationCode() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString+"456");
	}
	
	public static String userId() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return (generatedString);
	}
	public static String merchantAppKeyword() {
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return (generatedString.toUpperCase());
	}
	public static String merchantApplongkeyword() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return (generatedString.toUpperCase());
	}
	public static String merchantId() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}
	public static String userName() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	public static String custAppId() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}
	public static String userType() {
		Random rn = new Random();
		int max=3,min=0;
		  int range = max - min + 1;
		  int randomNum =  rn.nextInt(range) + min;
		  String type[]={"ADMIN", "MAKER","CHECKER", "INQUIRER"};
		  String string = type[randomNum];
		  return (string);
	}
	
	public static String alphaNumcontactPhone() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
	
	
}
