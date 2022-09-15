package com.cg.ofr.exception;

public class TenantNotFoundException extends RuntimeException{
	
	TenantNotFoundException(String message){
		super(message);
	}

}
