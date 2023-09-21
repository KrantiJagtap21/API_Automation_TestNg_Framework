package Test_Classes;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods;
import Common_API_Methods.Common_Utility_Method;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;
public class Post_TC1_Retry {
	@Test
	public static void extractor() throws IOException 
	{
		System.out.println("Extractor Method Called");
		for (int i=0; i<5 ; i++ ) 
		{
			int statusCode = API_Methods.ResponseStatusCode(
					Post_Req_Repository.BaseURI(), 
					Post_Req_Repository.Post_Resource(), 
					Post_Req_Repository.Post_Req_TC1());
	    if (statusCode==201)
	    {
	    	System.out.println(statusCode);
		    String ResponseBody = API_Methods.ResponseBody(
				Post_Req_Repository.BaseURI(), 
				Post_Req_Repository.Post_Resource(), 
				Post_Req_Repository.Post_Req_TC1());
		    System.out.println(ResponseBody);
		    String RequestBody = Post_Req_Repository.Post_Req_TC1();
		    Common_Utility_Method.EvidenceCreator("Post_TC1", RequestBody, ResponseBody, statusCode);
		    validator(RequestBody, ResponseBody);
            break;	
	   }
	  else
	  {
		System.out.println("Invalid Status Code :" +statusCode+"\n\n" );
	  }
   }
}

	public static void validator(String RequestBody, String ResponseBody) {
		System.out.println("Validator Method Called");
			JsonPath JspRequest = new JsonPath(RequestBody);
			String Req_name= JspRequest.getString("name");
			String Req_job = JspRequest.getString("job");
			LocalDateTime currentdate = LocalDateTime.now();
			String expecteddate = currentdate.toString().substring(0, 10);
			
			JsonPath JspResponse = new JsonPath(ResponseBody);
			String Res_name = JspResponse.getString("name");
			String Res_job = JspResponse.getString("job");
			String Res_createdAt = JspResponse.getString("createdAt");
			Res_createdAt = Res_createdAt.substring(0,10);
			
	        //Validate the Response Body 
	        Assert.assertEquals(Res_name, Req_name);
	        Assert.assertEquals(Res_job, Req_job);
	        Assert.assertEquals(Res_createdAt, expecteddate);
 
  }
}
