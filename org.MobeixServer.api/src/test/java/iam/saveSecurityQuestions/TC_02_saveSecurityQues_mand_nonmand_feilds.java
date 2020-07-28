package iam.saveSecurityQuestions;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_02_saveSecurityQues_mand_nonmand_feilds extends base{
	public static String question = RandomStringUtils.randomAlphabetic(10);
	public static String userKey;
	public static String createdDate = RandomStringUtils.randomNumeric(6);
	public static String flag;
	
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
		requestParams.put("question", question);
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
	public void TC_02_saveSecurityQues_using_Mandatory_and_Nonmandatory_feilds() {
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
