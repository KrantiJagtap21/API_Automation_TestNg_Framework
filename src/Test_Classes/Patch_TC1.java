package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods_Patch;
import Common_API_Methods.Common_Utility_Method;
import RequestRepository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	@Test 
	public static void extractor() throws IOException {
		int statusCode = API_Methods_Patch.ResponseStatusCode(Patch_Req_Repository.baseURI(), 
				Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_Req_TC());
		System.out.println(statusCode);
		String ResponseBody =API_Methods_Patch.ResponseBody(Patch_Req_Repository.baseURI(), 
				Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_Req_TC());
		System.out.println(ResponseBody);
		String RequestBody=Patch_Req_Repository.Patch_Req_TC();
		 Common_Utility_Method.EvidenceCreator("Patch_TC1", RequestBody, ResponseBody, statusCode);
		JsonPath Request =new JsonPath(RequestBody);
		String Req_name= Request.getString("name");
		String Req_job =Request.getString("job");
		
		JsonPath Response = new JsonPath(ResponseBody);
		String Res_name = Response.getString("name");
		String Res_job = Response.getString("job");
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
	}
}
