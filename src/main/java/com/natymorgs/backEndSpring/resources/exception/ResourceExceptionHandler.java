package com.natymorgs.backEndSpring.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.natymorgs.backEndSpring.services.exceptions.DataIntegretyException;
import com.natymorgs.backEndSpring.services.exceptions.ObjecNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjecNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjecNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
		@ExceptionHandler(DataIntegretyException.class)
		public ResponseEntity<StandardError> dataintegrety(DataIntegretyException e, HttpServletRequest request){
			
			StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
