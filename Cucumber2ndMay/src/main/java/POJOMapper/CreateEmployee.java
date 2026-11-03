package POJOMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateEmployee {
	
	public static String createEmp() throws JsonProcessingException
	{
		CreateEmployeePOJO emp=new CreateEmployeePOJO();
		emp.setName("Harry");
		emp.setJobRole("Manager");
		
		ObjectMapper obj=new ObjectMapper();
		
	String empJSON=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		return empJSON;
		
	}
	
	

}
