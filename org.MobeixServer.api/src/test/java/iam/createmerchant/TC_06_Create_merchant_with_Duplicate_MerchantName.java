package iam.createmerchant;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_06_Create_merchant_with_Duplicate_MerchantName extends base {
	public static String merchantappkeyword = RestUtil.merchantAppKeyword();
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		createMerchantDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("createdBy", createdBy);
		requestParams.put("merchantappkeyword", merchantappkeyword);
		requestParams.put("merchantName", merchantName);
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void TC_06_Create_merchant_with_Duplicate_MerchantName() {
		String responseBody = response.getBody().asString();
		logger.info("Response Body is==> " + responseBody);
		Assert.assertEquals(responseBody.contains(merchantappkeyword), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String s = String.valueOf(statusCode);
		 test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}
