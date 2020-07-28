package iam.saveSecurityQuestions;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_10_saveSecQues_with_11digit_version_number extends base {
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void saveSecurityQues() throws Throwable
	{
		saveSecurityQuestions();
		JSONObject requestParams = new JSONObject();
		requestParams.put("question", RandomStringUtils.randomAlphabetic(20));
		requestParams.put("createdBy", createdBy);
		requestParams.put("version",RandomStringUtils.random(11));
		header();
		JSONArray ja = new JSONArray();
		ja.add(requestParams);
		httpRequest.body(ja.toJSONString());
		response = httpRequest.request(Method.POST);

	}
	
	@Test
	public void TC__10_saveSecQues_with_11digit_version_number() {
		String responseBody = response.getBody().asString();
		//test.log(LogStatus.INFO, "Response Body is==> " + responseBody);
		 logger.info("Response Body is==> " + responseBody);
		//Assert.assertEquals(responseBody.contains(""), true);
		
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		 logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 500);
		String s = String.valueOf(statusCode);
		//test.log(LogStatus.INFO, "Status Code is==> " + s);
	}
}
