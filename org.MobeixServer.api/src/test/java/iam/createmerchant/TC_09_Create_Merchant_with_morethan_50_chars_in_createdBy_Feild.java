package iam.createmerchant;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_09_Create_Merchant_with_morethan_50_chars_in_createdBy_Feild extends base {
	public static String merchantappkeyword = RestUtil.merchantAppKeyword();
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		createMerchantDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("merchantappkeyword",merchantappkeyword);
		requestParams.put("createdBy", RandomStringUtils.randomAlphabetic(51));
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void TC_09_Create_Merchant_with_morethan_50_chars_in_createdBy_Feild() {
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
