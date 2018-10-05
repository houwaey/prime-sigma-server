package com.sigma.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sigma.dto.ExceptionObject;
import com.sigma.exception.AlreadyExistException;
import com.sigma.exception.BadRequestException;
import com.sigma.exception.DefaultException;
import com.sigma.exception.ForbiddenException;
import com.sigma.exception.InternalServerException;
import com.sigma.exception.NoContentException;
import com.sigma.exception.NotFoundException;
import com.sigma.exception.UnauthorizedException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Error.class })
    public final ResponseEntity<?> handleAllError(Error e, WebRequest r) {
        return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.INTERNAL_SERVER_ERROR
										, e.getMessage()
										, e.getCause() != null ? e.getCause().getMessage() : "N/A"
										, r.getDescription(true))
						, HttpStatus.OK
					);
    }
	
	@ExceptionHandler({ Exception.class })
    public final ResponseEntity<?> handleAllException(Exception e, WebRequest r) {
        return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.INTERNAL_SERVER_ERROR
										, e.getMessage()
										, e.getCause() != null ? e.getCause().getMessage() : "N/A"
										, r.getDescription(true))
						, HttpStatus.OK
					);
    }
	
	@ExceptionHandler({
		DefaultException.class, 
		AlreadyExistException.class,
		BadRequestException.class,
		ForbiddenException.class,
		InternalServerException.class,
		NoContentException.class,
		NotFoundException.class,
		UnauthorizedException.class
	})
	public final ResponseEntity<?> handleDefaultException(DefaultException e, WebRequest r) {
		return new ResponseEntity<Object>(
						new ExceptionObject(e.getHttpStatus()
										, e.getMessage()
										, e.getCause() != null ? e.getCause().getMessage() : "N/A"
										, r.getDescription(true))
						, HttpStatus.OK
					);
	}
	
}
