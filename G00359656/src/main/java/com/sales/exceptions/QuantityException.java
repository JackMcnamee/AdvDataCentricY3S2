package com.sales.exceptions;

public class QuantityException extends RuntimeException {

	private String exceptionMsg;

	public QuantityException(String exceptionMsg) {
		//super();
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	
}
