package com.cg.ofr.exception;

public class UserNotFoundException extends RuntimeException{

	UserNotFoundException(String message){
		super(message);
	}
}
