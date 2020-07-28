package iam.saveSecurityQuesForUser;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_02_saveSecQues_using_Mand_Nonmand_feilds extends base{
	public static String question = RandomStringUtils.randomAlphabetic(10);
	public static String createdDate = RandomStringUtils.randomNumeric(6);
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void saveSecurityQues() throws Throwable
	{
		saveUserSecurityQuestions1();
		JSONObject requestParams = new JSONObject();
		requestParams.put("appId", appId);
		requestParams.put("appKey", appKey);
		requestParams.put("updatedBy", createdBy);
		requestParams.put("ltbPrimaryKey", ltbPrimaryKey);
		requestParams.put("secretAns", createdBy);
		requestParams.put("securityKey",2 );
		requestParams.put("question", question);
		requestParams.put("createdBy", createdBy);
		requestParams.put("createdDate", createdDate);
		requestParams.put("flag", null);
		requestParams.put("lastAction", "df");
		requestParams.put("status", "ACTIVE");
		requestParams.put("userKey", 135);
		JSONArray ja = new JSONArray();
		ja.add(requestParams);
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("appId", appId);
		requestParams1.put("appKey", appKey);
		requestParams1.put("updatedBy", createdBy);
		requestParams1.put("ltbPrimaryKey", ltbPrimaryKey);
		requestParams1.put("secretAns", createdBy);
		requestParams1.put("securityKey",3 );
		requestParams1.put("question", question);
		requestParams1.put("createdBy", createdBy);
		requestParams1.put("createdDate", createdDate);
		requestParams1.put("flag", null);
		requestParams1.put("lastAction", "df");
		requestParams1.put("status", "ACTIVE");
		requestParams1.put("userKey", 135);
		ja.add(requestParams1);
		JSONObject requestParams2 = new JSONObject();
		requestParams2.put("appId", appId);
		requestParams2.put("appKey", appKey);
		requestParams2.put("updatedBy", createdBy);
		requestParams2.put("ltbPrimaryKey", ltbPrimaryKey);
		requestParams2.put("secretAns", createdBy);
		requestParams2.put("securityKey",4 );
		requestParams2.put("question", question);
		requestParams2.put("createdBy", createdBy);
		requestParams2.put("createdDate", createdDate);
		requestParams2.put("flag", null);
		requestParams2.put("lastAction", "df");
		requestParams2.put("status", "ACTIVE");
		requestParams2.put("userKey", 135);
		ja.add(requestParams2);
		JSONObject requestParams3 = new JSONObject();
		requestParams3.put("appId", appId);
		requestParams3.put("appKey", appKey);
		requestParams3.put("updatedBy", createdBy);
		requestParams3.put("ltbPrimaryKey", ltbPrimaryKey);
		requestParams3.put("secretAns", createdBy);
		requestParams3.put("securityKey",5 );
		requestParams3.put("question", question);
		requestParams3.put("createdBy", createdBy);
		requestParams3.put("createdDate", createdDate);
		requestParams3.put("flag", null);
		requestParams3.put("lastAction", "df");
		requestParams3.put("status", "ACTIVE");
		requestParams3.put("userKey", 135);
		ja.add(requestParams3);
		JSONObject requestParams4 = new JSONObject();
		requestParams4.put("appId", appId);
		requestParams4.put("appKey", appKey);
		requestParams4.put("updatedBy", createdBy);
		requestParams4.put("ltbPrimaryKey", ltbPrimaryKey);
		requestParams4.put("secretAns", createdBy);
		requestParams4.put("securityKey",22 );
		requestParams4.put("question", question);
		requestParams4.put("createdBy", createdBy);
		requestParams4.put("createdDate", createdDate);
		requestParams4.put("flag", null);
		requestParams4.put("lastAction", "df");
		requestParams4.put("status", "ACTIVE");
		requestParams4.put("userKey", 135);
		ja.add(requestParams4);
		header();
		httpRequest.body(ja.toJSONString());
		response = httpRequest.request(Method.POST);

	}
	
	@Test
	public void TC__02_saveSecurityQues_using_Manda_NonMand_feilds() {
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
