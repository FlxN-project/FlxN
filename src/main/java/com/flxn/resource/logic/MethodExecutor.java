package com.flxn.resource.logic;

import com.flxn.dao.modelapi.ModelInterface;
import com.flxn.service.api.BasicService;
import com.flxn.service.logic.DeferredResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gadzzzz on 17.04.2016.
 */
public class MethodExecutor<T extends ModelInterface> {

	private BasicService<T> basicService;

	public MethodExecutor(BasicService<T> basicService) {
		this.basicService = basicService;
	}

	public ResponseEntity<?> create(T model, BindingResult bindingResults){
		if(bindingResults.hasErrors())
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		DeferredResponse<T> deferredResponse = new DeferredResponse<>();
		basicService.create(model,deferredResponse);
		deferredResponse.defer();
		if(deferredResponse.getException()!=null)
			return new ResponseEntity(HttpStatus.CONFLICT);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	public ResponseEntity<?> update(int id, T model, BindingResult bindingResults){
		if (bindingResults.hasErrors())
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		DeferredResponse<T> deferredResponse = new DeferredResponse<>();
		model.setId(id);
		basicService.update(model,deferredResponse);
		deferredResponse.defer();
		if(deferredResponse.getException()!=null)
			return new ResponseEntity(HttpStatus.CONFLICT);
		return new ResponseEntity(HttpStatus.OK);
	}
}
