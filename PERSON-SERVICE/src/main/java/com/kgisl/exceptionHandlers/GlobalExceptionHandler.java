package com.kgisl.exceptionHandlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class GlobalExceptionHandler.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Resource not found exception.
	 *
	 * @param resourceNotFoundException the resourceNotFoundException
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceNotFoundException.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	/**
	 * Global exception handler.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
