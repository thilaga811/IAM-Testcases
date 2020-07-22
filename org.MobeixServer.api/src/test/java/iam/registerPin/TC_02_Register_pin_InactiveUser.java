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
public class TC_02_Register_pin_InactiveUser extends base{
	@SuppressWarnings("unchecked")
	@BeforeClass

	public void registerUserpin() throws Throwable
	{
		String key=base.encrypt1("Sana", "3645");
		System.out.println("KEY :"+key);
		registerUserPin();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "Sana");
		requestParams.put("groupId", groupId);
		requestParams.put("currentPIN", currentPIN);
		requestParams.put("newPIN",key);
		requestParams.put("confirmNewPIN",key);
		requestParams.put("custAppId", custAppId);
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void TC__02_Register_Userpin_InactiveUser() {
		String responseBody = response.getBody().asString();
		//logger.info("Response Body is==> " + responseBody);
		//Assert.assertEquals(responseBody.contains(" "), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		 Assert.assertEquals(responseBody.contains("USER_LOCKED_DEACTIVATED"), true);
		int statusCode = response.getStatusCode();
		//logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 400);
		String s = String.valueOf(statusCode);
		 test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}
