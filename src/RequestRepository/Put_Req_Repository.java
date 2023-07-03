package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utility_Method;

public class Put_Req_Repository {
	public static String BaseURI() {
		String BaseURI = "https://reqres.in/";
		return BaseURI;
		}
		public static String Put_Resource() {
			String Put_Resource ="api/users/2";
			return Put_Resource;
		}
		public static String Put_Req_TC1() throws IOException {
			ArrayList<String> Req_Data=Common_Utility_Method.ReadDataExcel("PutAPI","TC2");
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
