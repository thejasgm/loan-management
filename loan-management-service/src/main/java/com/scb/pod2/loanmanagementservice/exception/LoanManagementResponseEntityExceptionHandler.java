/**
 * 
 */
package com.scb.pod2.loanmanagementservice.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author 787476
 *
 */



@ControllerAdvice

public class LoanManagementResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanManagementResponseEntityExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResonse=new ExceptionResponse(new Date(), ex.getMessage(), "error exception response: Internal Server Error");
		LOGGER.error("bodyOfResponse", ex);
		return  new ResponseEntity(exceptionResonse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(LoanManagementDataNotFound.class)
	public final ResponseEntity<Object> handleEnrollmentNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionResponse exceptionResonse=new ExceptionResponse(new Date(), ex.getMessage(), "error exception  response :Resource Not Found ");
		LOGGER.error("bodyOfResponse", ex);
		return  new ResponseEntity(exceptionResonse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<Object> handle(IllegalArgumentException e, final WebRequest request) {
		
		LOGGER.error("bodyOfResponse", e);
		return handleExceptionInternal(e,  e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

/*	@ExceptionHandler({ NullPointerException.class, IllegalStateException.class })
	public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {

		LOGGER.error("bodyOfResponse", ex);
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}
*/
}



