package com.flxn.resource;

import com.flxn.dao.model.Project;
import com.flxn.dao.model.Value;
import com.flxn.service.api.ProjectService;
import com.flxn.service.logic.DeferredResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
@RestController
@RequestMapping(value = "project")
public class ProjectResource {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@Validated @RequestBody Project project,
											  BindingResult bindingResults){
		if(bindingResults.hasErrors())
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		DeferredResponse<Project> deferredResponse = new DeferredResponse<>();
		projectService.create(project,deferredResponse);
		deferredResponse.defer();
		if(deferredResponse.getException()!=null)
			return new ResponseEntity(HttpStatus.CONFLICT);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
