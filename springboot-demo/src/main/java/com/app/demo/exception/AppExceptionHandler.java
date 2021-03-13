package com.app.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.demo.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest req) {
		String errorMessageDescription = ex.getLocalizedMessage();
		
		if(errorMessageDescription == null) errorMessageDescription = ex.getMessage();
		
		ErrorMessage errMsg = new ErrorMessage(errorMessageDescription, new Date());
		
		return new ResponseEntity<Object>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
