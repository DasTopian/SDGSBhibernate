package com.lti.rest;

import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import com.lti.rest.exception.DBException;


@Path("/register")	
public class RegisterService {

	
	@POST
	@Consumes("application/json") 
    @Produces("application/json")
    public Status process(Register register){
	
		//System.out.println(json);
		//System.out.println(register);
		RegisterDao dao = new RegisterDao();
		dao.add(register);
		
		Status status=new Status();
		status.setStatusCode(111);
		status.setStatusMessage("Customer Registered Successfully");
		
		
		return status;
	}
}
