package com.jpm.stocks.simple.supr.exception;

public class IllegalStockTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalStockTypeException(String invalidStockType) {
		super(invalidStockType + " is an invalid Stock type.");
	}

}
