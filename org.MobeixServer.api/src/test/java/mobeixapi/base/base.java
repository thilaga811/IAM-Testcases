package mobeixapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mobeixapi.utilities.RestUtil;

public class base {
	public static RequestSpecification httpRequest;
	public static Response response;
	public Logger logger;
	public static ExtentReports reports;
	public static ExtentTest test;
	//public static String SystemURl="http://172.17.2.28:8081/";  //MERCHANT MANAGEMENT ENVIORMENT
	//public static String SystemURL1="http://172.17.1.96:9896/";
	public static String SystemURL2="http://172.17.1.116:8480/";//USER MANAGEMENT ENVIORMENT
	public static String merchantName = RestUtil.merchantName();
	public static String groupId ="MOBEIX";
	public static String appId = null;
	public static String appVersion = "1.0";
	
	public static String currentPIN ="";
	//public static String pin = encrypt();
	public static String newPIN;
	public static String confirmNewPIN;
	public static String custAppId =RestUtil.custAppId();
	public static String createdBy = RestUtil.createdBy();	
	public static String merchantId = RestUtil.merchantId();
	public static String contactEmail = RestUtil.contactEmail();
	public static String contactPhone = RestUtil.contactPhone();
	public static String contactName = RestUtil.contactName();
	public static String merchantapplongkeyword = RestUtil.merchantApplongkeyword();
	public static String contactAddress = RestUtil.contactAddress();
	public static String registrationCode = RestUtil.registrationCode();
	public static String productCategory = RestUtil.productCategory();
	public static String userId = RestUtil.userId();
	public static String userName = RestUtil.userName();
	public static String userType = RestUtil.userType();
	public static String alphaNumcontactPhone = RestUtil.alphaNumcontactPhone();
	public static JSONObject requestParams;
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("MOBEIX API");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	public static void postReq() {
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	public static void header() {
		httpRequest.header("Content-Type","application/json");
		//httpRequest.header("groupId","MOBEIX");
		//httpRequest.header("userId","Thilaga");
	}
	
	public static String encrypt1(Object uID, String mailID) {
		RestAssured.baseURI = "http://172.17.1.116:8480/mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", uID);
		requestParams.put("emailId", mailID);
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}
	
	public static String encryptwithGroup(Object uID, String mailID, String grbID) {
		RestAssured.baseURI = "http://172.17.1.116:8480/mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", uID);
		requestParams.put("emailId", mailID);
		requestParams.put("groupId", grbID);
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}
	public static void createMerchantDetails() {
		RestAssured.baseURI=SystemURL2+"mxcomponentapi/accessmanagement/merchants/saveMerchant";
		httpRequest=RestAssured.given();
	}
	public static void getMerchantdetails() throws Throwable {
		RestAssured.baseURI=SystemURL2+"mxcomponentapi/accessmanagement/merchants/DA";
		httpRequest=RestAssured.given();
	}
	public static void registerUserPin() throws Throwable {
		RestAssured.baseURI=SystemURL2+"mxcomponentapi/usermanagement/merchants/MX/registerUserPIN";
		httpRequest=RestAssured.given();
	}

}
