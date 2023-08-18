package com.Employee.Exception;


import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Employee.Payloads.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex){
		
		String msg = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse();
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		  Map<String,String> errRsp=new HashMap<>();
		  ex.getBindingResult().getAllErrors().forEach((error)->{
		   String fieldName=((FieldError)error).getField();
		   String errMsg=error.getDefaultMessage();
		   errRsp.put(fieldName, errMsg);
		  });
	  
	 	 return new ResponseEntity<Map<String,String>>(errRsp,HttpStatus.BAD_REQUEST);
	 }
}
