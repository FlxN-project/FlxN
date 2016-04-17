package com.flxn.resource;

import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;
import com.flxn.resource.logic.MethodExecutor;
import com.flxn.service.api.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
@RestController
@RequestMapping(value = "project")
public class ProjectResource {

	@Autowired
	@Qualifier("projectService")
	private BasicService<Project> projectService;

	private MethodExecutor<Project> executor;

	private MethodExecutor<Project> getExecutor(){
		if(executor==null)
			executor = new MethodExecutor<>(projectService);
		return executor;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@Validated @RequestBody Project project,
											  BindingResult bindingResults,
											  HttpServletRequest request){
		User auth = (User) request.getAttribute("auth");
		project.setParent(auth);
		return getExecutor().create(project,bindingResults);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") int id,
											  @Validated @RequestBody Project project,
											  BindingResult bindingResults,
											  HttpServletRequest request){
		User auth = (User) request.getAttribute("auth");
		project.setParent(auth);
		return getExecutor().update(id,project,bindingResults);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable("id") int id){
		return getExecutor().get(id);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<?>> getAll(HttpServletRequest request){
		User auth = (User) request.getAttribute("auth");
		return getExecutor().getAll(auth);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return getExecutor().delete(id, new Project());
	}
}
