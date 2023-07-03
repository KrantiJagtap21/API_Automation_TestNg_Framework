package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utility_Method;

public class Post_Req_Repository {

	public static String BaseURI() {
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String Post_Resource() {
		String Post_Resource ="api/users";
		return Post_Resource;
	}
	public static String Post_Req_TC1() throws IOException {
		ArrayList<String> Req_Data=Common_Utility_Method.ReadDataExcel("PostAPI","TC2");
		System.out.println(Req_Data); 
		String Req_name=Req_Data.get(1);
		String Req_job=Req_Data.get(2);
		String RequestBody ="{\r\n"
				+ "    \"name\": \""+Req_name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
	    return RequestBody;
	}
}

