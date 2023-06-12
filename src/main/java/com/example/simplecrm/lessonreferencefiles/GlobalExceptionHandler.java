package com.example.simplecrm;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  // HANDLE VALIDATION ERRORS
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    // Get list of all validation errors from the exception object
    List<ObjectError> validationErrors = ex.getBindingResult().getAllErrors();

    // Create a StringBuilder to store all error messages
    StringBuilder sb = new StringBuilder();

    // Loop through all the errors and append the error messages to the
    // StringBuilder
    for (ObjectError error : validationErrors) {
      sb.append(error.getDefaultMessage() + " ");
    }

    // Create custom error response
    ErrorResponse errorResponse = new ErrorResponse(sb.toString());

    // Return
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

  }

  // HANDLE ALL OTHER EXCEPTIONS
  // General exception handler - handle any uncaught exception
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAllExceptions(Exception ex) {

    // ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    ErrorResponse errorResponse = new ErrorResponse("Something went wrong. Please try again later.");
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler({ CustomerNotFoundException.class, InteractionNotFoundException.class })
  public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {

    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  // @ExceptionHandler(CustomerNotFoundException.class)
  // public ResponseEntity<Object>
  // handleCustomerNotFoundException(CustomerNotFoundException ex) {

  // ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
  // return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  // }

  // HANDLE UNSUCCESSFUL DELETION
  @ExceptionHandler(EmptyResultDataAccessException.class)
  public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
    ErrorResponse errorResponse = new ErrorResponse("Cannot delete item that doesn't exist.");
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

}
