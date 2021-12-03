package br.com.luish.management.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	//Error to Json invalid
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> badRequest(HttpMessageNotReadableException e, HttpServletRequest request){
		
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<StandardError> nullPointer(NullPointerException e, HttpServletRequest request){
		
		StandardError error = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		
	}
	
}
