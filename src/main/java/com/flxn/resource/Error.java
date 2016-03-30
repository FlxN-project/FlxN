package com.flxn.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gadzzzz on 30.03.2016.
 */
@RestController
public class Error {

	@RequestMapping(value = "/error")
	public ResponseEntity<?> error(HttpServletRequest request){
		ResponseEntity err;
		try{
			int status = Integer.parseInt(request.getParameter("stcode"));
			err = new ResponseEntity(HttpStatus.valueOf(status));
		}catch (NumberFormatException e){
			err = new ResponseEntity(HttpStatus.BAD_GATEWAY);
		}
		return err;
	}
}
