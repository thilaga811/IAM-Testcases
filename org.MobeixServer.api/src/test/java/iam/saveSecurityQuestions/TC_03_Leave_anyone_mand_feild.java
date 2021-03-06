package iam.saveSecurityQuestions;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_03_Leave_anyone_mand_feild extends base{
	public static String userKey;
	public static String createdDate = RandomStringUtils.randomNumeric(6);
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void saveSecurityQues() throws Throwable
	{
		saveSecurityQuestions();
		JSONObject requestParams = new JSONObject();
		requestParams.put("appId", appId);
		requestParams.put("appKey", appKey);
		requestParams.put("updatedBy", createdBy);
		requestParams.put("ltbPrimaryKey", ltbPrimaryKey);
		requestParams.put("secretAns", createdBy);
		requestParams.put("securityKey",securityKey );
		//requestParams.put("question", createdBy);
		requestParams.put("createdBy", createdBy);
		requestParams.put("createdDate", createdDate);
		requestParams.put("flag", null);
		requestParams.put("lastAction", "df");
		requestParams.put("status", "ACTIVE");
		requestParams.put("userKey", 135);
		header();
		JSONArray ja = new JSONArray();
		ja.add(requestParams);
		httpRequest.body(ja.toJSONString());
		response = httpRequest.request(Method.POST);

	}
	
	@Test
	public void TC__03_saveSecurityQues_using_Mandatory_nonMand_feilds() {
		String responseBody = response.getBody().asString();
		//test.log(LogStatus.INFO, "Response Body is==> " + responseBody);
		 logger.info("Response Body is==> " + responseBody);
		Assert.assertEquals(responseBody.contains("SECURITY_QUESTION_MANDATORY"), true);
		
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		 logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 400);
		String s = String.valueOf(statusCode);
		//test.log(LogStatus.INFO, "Status Code is==> " + s);
	}
}
