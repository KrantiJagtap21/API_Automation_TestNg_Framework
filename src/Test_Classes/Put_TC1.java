package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods_Put;
import Common_API_Methods.Common_Utility_Method;
import RequestRepository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	@Test 
 public static void extractor() throws IOException 
 {
	 int statusCode= API_Methods_Put.ResponseStatusCode(Put_Req_Repository.BaseURI(),
			 Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_Req_TC1());
	 System.out.println(statusCode);
	 String ResponseBody= API_Methods_Put.ResponseBody(Put_Req_Repository.BaseURI(), 
			 Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_Req_TC1());
	 System.out.println(ResponseBody);
	 
	 String RequestBody= Put_Req_Repository.Put_Req_TC1();
	 Common_Utility_Method.EvidenceCreator("Put_TC1", RequestBody, ResponseBody, statusCode);
	 JsonPath Request= new JsonPath(RequestBody);
	 String Req_name = Request.getString("name");
	 String Req_job= Request.getString("job");
	 
			 
	 JsonPath Response = new JsonPath(ResponseBody);
		String Res_name = Response.getString("name");
		String Res_job = Response.getString("job");
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
 }
}
