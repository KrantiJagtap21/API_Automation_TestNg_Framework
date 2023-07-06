# API_Automation_TestNg_Framework
This project is capable to execute, extract response, parse the response, validate the response of all the methods POST,PUT, PATCH and GET automatically.
Users can also construct the request body using parameters from Excel file for that I have created a common utility method using ApachePoi to read data from Excel.
This project is built on the concept of data-driven and keyword driven:
      I have divided the project into four packages request repository, test class, common methods and driver class.
The test execution is driven by TestNG XML.
I have created a method in common utility class so the project is capable to save the evidence of execution into text files which contain details of request sent, endpoint and response received.
