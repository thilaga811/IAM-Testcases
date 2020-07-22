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

public class TC_01_Create_Merchant_using_Mandatory_feilds extends base {

	public static String merchantappkeyword = RestUtil.merchantAppKeyword();
	public static String createdBy = RestUtil.createdBy();
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		createMerchantDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("merchantappkeyword", merchantappkeyword);
		//System.out.println(merchantappkeyword);
		requestParams.put("createdBy", createdBy);
		//System.out.println(createdBy);
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void TC__01_Create_Merchant_using_Mandatory_feilds() {
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
