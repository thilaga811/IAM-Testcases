package iam.registerPin;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_09_registerMpin_for_registeredUser extends base{

	@SuppressWarnings("unchecked")
	@BeforeClass
	
	public void registerUserpin() throws Throwable
	{
		String key=base.encrypt1("aravind1", "6536");
		System.out.println("KEY :"+key);
		registerUserPin();
		//String pin = encrypt();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "aravind1");
		requestParams.put("groupId", groupId);
		requestParams.put("currentPIN", "");
		requestParams.put("newPIN",key);
		requestParams.put("confirmNewPIN",key);
		requestParams.put("custAppId", custAppId);
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void TC__09() {
		String responseBody = response.getBody().asString();
		//logger.info("Response Body is==> " + responseBody);
		//Assert.assertEquals(responseBody.contains(" "), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		//logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String s = String.valueOf(statusCode);
		 test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

		
}
