package com.jp.exception;

public class Exception1 extends Exception {

	private static final long serialVersionUID = 1L;

	Exception1(String message) {
		super(message);
	}

	Exception1(Throwable throwable) {
		super(throwable);
	}

}
