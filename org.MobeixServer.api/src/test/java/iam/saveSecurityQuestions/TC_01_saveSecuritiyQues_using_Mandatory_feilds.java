package iam.saveSecurityQuestions;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import mobeixapi.base.base;
public class TC_01_saveSecuritiyQues_using_Mandatory_feilds extends base {
	public static String userKey;
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void saveSecurityQues() throws Throwable
	{
		saveSecurityQuestions();
		JSONObject requestParams = new JSONObject();
		requestParams.put("question", createdBy);
		requestParams.put("createdBy", createdBy);
		JSONArray ja = new JSONArray();
		ja.add(requestParams);
		header();
		httpRequest.body(ja.toJSONString());
		response = httpRequest.request(Method.POST);

	}
	
	@Test
	public void TC__01_saveSecurityQues_using_Mandatory_feilds() {
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
