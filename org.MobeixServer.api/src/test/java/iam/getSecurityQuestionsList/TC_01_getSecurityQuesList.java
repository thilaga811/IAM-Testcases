package iam.getSecurityQuestionsList;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
public class TC_01_getSecurityQuesList extends base{
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void getSecQuesList() throws Throwable
	{
		getSecurityQuestionsList();
		header();
		JSONObject requestParams = new JSONObject();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.GET);
		
	}
	@Test
	public void TC__01_getSecurityQuestionsList() {
		String responseBody = response.getBody().asString();
		//test.log(LogStatus.INFO, "Response Body is==> " + responseBody);
		 logger.info("Response Body is==> " + responseBody);
		//Assert.assertEquals(responseBody.contains(""), true);
		
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String s = String.valueOf(statusCode);
		//test.log(LogStatus.INFO, "Status Code is==> " + s);
	}
}
