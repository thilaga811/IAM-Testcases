package iam.getMerchantDetails;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.utilities.RestUtil;
import mobeixapi.base.base;

public class TC_01_getMerchantDetails extends base {
	//public static String merchantappkeyword = "DA";

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void getMerchantDetails() throws Throwable {
		getMerchantdetails();
		//JSONObject requestParams = new JSONObject();
		header();
		//httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.GET);
	}

	@Test
	public void TC__01_getMerchantdetails() {
		String responseBody = response.getBody().asString();
		test.log(LogStatus.INFO, "Response Body is==> " + responseBody);
		// logger.info("Response Body is==> " + responseBody);
		Assert.assertEquals(responseBody.contains("DA"), true);
		
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		// logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String s = String.valueOf(statusCode);
		test.log(LogStatus.INFO, "Status Code is==> " + s);
	}

}
