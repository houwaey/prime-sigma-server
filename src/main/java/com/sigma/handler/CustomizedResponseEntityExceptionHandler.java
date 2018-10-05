package com.sigma.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sigma.dto.ExceptionObject;
import com.sigma.exception.AlreadyExistException;
import com.sigma.exception.BadRequestException;
import com.sigma.exception.ForbiddenException;
import com.sigma.exception.InternalServerException;
import com.sigma.exception.NoContentException;
import com.sigma.exception.NotFoundException;
import com.sigma.exception.UnauthorizedException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Error.class })
    public final ResponseEntity<Object> handleAllError(Error err, WebRequest request) {
        return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.INTERNAL_SERVER_ERROR
										, err.getMessage()
										, err.getCause() != null ? err.getCause().getMessage() : "N/A"
										, request.getDescription(true))
						, HttpStatus.INTERNAL_SERVER_ERROR
					);
    }
	
	@ExceptionHandler({ Exception.class })
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.INTERNAL_SERVER_ERROR
										, ex.getMessage()
										, ex.getCause() != null ? ex.getCause().getMessage() : "N/A"
										, request.getDescription(true))
						, HttpStatus.INTERNAL_SERVER_ERROR
					);
    }
	
	@ExceptionHandler({ UnauthorizedException.class })
	public final ResponseEntity<Object> handleUnauthorizedException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.UNAUTHORIZED
										, ex.getMessage()
										, ex.getCause() != null ? ex.getCause().getMessage() : "N/A"
										, request.getDescription(true))
						, HttpStatus.UNAUTHORIZED
					);
	}
	
	@ExceptionHandler({ ForbiddenException.class })
	public final ResponseEntity<Object> handleForbiddenException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.FORBIDDEN
										, ex.getMessage()
										, ex.getCause() != null ? ex.getCause().getMessage() : "N/A"
										, request.getDescription(true))
						, HttpStatus.FORBIDDEN
					);
	}
	
	@ExceptionHandler({ InternalServerException.class })
	public final ResponseEntity<Object> handleInternalServerException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.INTERNAL_SERVER_ERROR
										, ex.getMessage()
										, ex.getCause() != null ? ex.getCause().getMessage() : "N/A"
										, request.getDescription(true))
						, HttpStatus.INTERNAL_SERVER_ERROR
					);
	}
	
	@ExceptionHandler({ UsernameNotFoundException.class, NotFoundException.class })
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.NOT_FOUND
										, ex.getMessage()
										, ex.getCause() != null ? ex.getCause().getMessage() : "N/A"
										, request.getDescription(true))
						, HttpStatus.NOT_FOUND
					);
	}
	
	@ExceptionHandler({ AlreadyExistException.class })
	public final ResponseEntity<Object> handleAlreadyExistException(Exception e, WebRequest r) {
		return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.PRECONDITION_FAILED
										, e.getMessage()
										, e.getCause() != null ? e.getCause().getMessage() : "N/A"
										, r.getDescription(true))
						, HttpStatus.PRECONDITION_FAILED
					);
	}
	
	@ExceptionHandler({ BadRequestException.class })
	public final ResponseEntity<Object> handleBadRequestException(Exception e, WebRequest r) {
		return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.BAD_REQUEST
										, e.getMessage()
										, e.getCause() != null ? e.getCause().getMessage() : "N/A"
										, r.getDescription(true))
						, HttpStatus.BAD_REQUEST
					);
	}
	
	@ExceptionHandler({ NoContentException.class })
	public final ResponseEntity<Object> handleNoContentException(Exception e, WebRequest r) {
		return new ResponseEntity<Object>(
						new ExceptionObject(HttpStatus.NO_CONTENT
										, e.getMessage()
										, e.getCause() != null ? e.getCause().getMessage() : "N/A"
										, r.getDescription(true))
						, HttpStatus.NO_CONTENT
					);
	}
	
}
