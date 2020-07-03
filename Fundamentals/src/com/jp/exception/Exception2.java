package com.jp.exception;

public class Exception2 extends RuntimeException {

	private static final long serialVersionUID = 1L;

	Exception2(String message) {
		super(message);
	}

	Exception2(Throwable throwable) {
		super(throwable);
	}
}
