package com.flxn.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
@Path("/hello")
public class HelloResource {
	@GET
	public Response getMsg(){
		String out = "Jersey say:";
		return Response.status(200).entity(out).build();
	}
}