package com.learning.vending.resource.server.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.learning.vending.resource.server.exception.VendingMachineUserDataException;

@ControllerAdvice
public class VendingMachineGlobalException {
	
	@ExceptionHandler({ VendingMachineUserDataException.class })
    public ResponseEntity<String> handleUserDataException(
      Exception ex, WebRequest request) {
        return new ResponseEntity<String>(
          ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
	
//	@ExceptionHandler({ RuntimeException.class })
//    public ResponseEntity<String> handleRuntimeException(
//      Exception ex, WebRequest request) {
//        return new ResponseEntity<String>(
//          "Internal Server error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
	
}
