package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utility_Method;

public class Patch_Req_Repository {

	public static String baseURI() {
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String Patch_Resource() {
		String Patch_Resource = "api/users/2";
		return Patch_Resource;
	}
	public static String Patch_Req_TC() throws IOException {
		ArrayList<String> Req_Data=Common_Utility_Method.ReadDataExcel("PatchAPI", "TC3");
		String Req_name=Req_Data.get(1);
		String Req_job= Req_Data.get(2);
		String RequestBody = "{\r\n"
				+ "    \"name\": \""+Req_name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return RequestBody;
	}
}
