package iam.getMerchantDetails;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;
public class TC_03_Get_deleted_MerchantDetails extends base{
	public static void getMerchantdetails() throws Throwable {
		RestAssured.baseURI=SystemURL2+"mxcomponentapi/accessmanagement/merchants/AD";
		httpRequest=RestAssured.given();
	}
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
	public void TC_03_GetDeletedMerchantDetails() {
		String responseBody = response.getBody().asString();
		test.log(LogStatus.INFO, "Response Body is==> " + responseBody);
		// logger.info("Response Body is==> " + responseBody);
		Assert.assertEquals(responseBody.contains("BV"), true);
		
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		// logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String s = String.valueOf(statusCode);
		test.log(LogStatus.INFO, "Status Code is==> " + s);
	}

}
