package iam.registerPin;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_04_RegisterMpin_with_NonMandatory_feilds extends base {
	@SuppressWarnings("unchecked")
	@BeforeClass
	
	public void registerUserpin() throws Throwable
	{
		String key=base.encrypt1("Siva", "4536");
		System.out.println("KEY :"+key);
		registerUserPin();
		//String pin = encrypt();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "Siva");
		requestParams.put("groupId", groupId);
		requestParams.put("currentPIN", "");
		requestParams.put("newPIN",key);
		requestParams.put("confirmNewPIN",key);
		requestParams.put("custAppId", custAppId);
		requestParams.put("appId", appId);
		requestParams.put("appVersion", appVersion);
		requestParams.put("deviceImei", "356453");
		requestParams.put("deviceModel", "Redmi");
		requestParams.put("deviceOs", "9.0");
		requestParams.put("deviceRooted", "yes");
		requestParams.put("isPrimary", 1);
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void TC__04() {
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
