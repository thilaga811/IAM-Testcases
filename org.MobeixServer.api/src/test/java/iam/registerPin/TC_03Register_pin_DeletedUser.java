package iam.registerPin;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;
public class TC_03Register_pin_DeletedUser extends base {
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	
	
	public void registerUserpin() throws Throwable
	{
		String key=base.encryptwithGroup("Diya", "2345", "TEST");
		//String key=base.encrypt1("Thilaga", "2345");
		System.out.println("KEY :"+key);
		registerUserPin();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "Diya");
		requestParams.put("groupId", "TEST");
		requestParams.put("currentPIN", currentPIN);
		requestParams.put("newPIN",key);
		requestParams.put("confirmNewPIN",key);
		requestParams.put("custAppId", custAppId);
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void TC__03_Register_Userpin_DeletedUser() {
		String responseBody = response.getBody().asString();
		//logger.info("Response Body is==> " + responseBody);
		Assert.assertEquals(responseBody.contains("USER_NOT_EXIST"), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		//logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 400);
		String s = String.valueOf(statusCode);
		 test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}
