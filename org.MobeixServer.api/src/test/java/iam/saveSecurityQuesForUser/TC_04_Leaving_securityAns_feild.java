package iam.saveSecurityQuesForUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import mobeixapi.base.base;
public class TC_04_Leaving_securityAns_feild extends base {
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void saveSecurityQues() throws Throwable
	{
		saveUserSecurityQuestions();
		JSONObject requestParams = new JSONObject();
		//requestParams.put("secretAns", createdBy);
		requestParams.put("securityKey",2 );
		requestParams.put("createdBy", "Thilaga");
		JSONArray ja = new JSONArray();
		ja.add(requestParams);
		JSONObject requestParams1 = new JSONObject();
		//requestParams.put("secretAns", createdBy);
		requestParams1.put("securityKey",3 );
		requestParams1.put("createdBy", "Thilaga");
		ja.add(requestParams1);
		JSONObject requestParams2 = new JSONObject();
		//requestParams.put("secretAns", createdBy);
		requestParams2.put("securityKey",4 );
		requestParams2.put("createdBy", "Thilaga");
		ja.add(requestParams2);
		JSONObject requestParams3 = new JSONObject();
		//requestParams.put("secretAns", createdBy);
		requestParams3.put("securityKey",5 );
		requestParams3.put("createdBy", "Thilaga");
		ja.add(requestParams3);
		JSONObject requestParams4 = new JSONObject();
		//requestParams.put("secretAns", createdBy);
		requestParams4.put("securityKey",22 );
		requestParams4.put("createdBy", "Thilaga");
		ja.add(requestParams4);
		header();
		httpRequest.body(ja.toJSONString());
		response = httpRequest.request(Method.POST);

	}
	
	@Test
	public void TC__04_saveSecurityQues_leaving_securityAns_feild() {
		String responseBody = response.getBody().asString();
		//test.log(LogStatus.INFO, "Response Body is==> " + responseBody);
		 logger.info("Response Body is==> " + responseBody);
		Assert.assertEquals(responseBody.contains("SECURITY_QUES_ANS_MANDATORY"), true);
		
		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		 logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 400);
		String s = String.valueOf(statusCode);
		//test.log(LogStatus.INFO, "Status Code is==> " + s);
	}
}
