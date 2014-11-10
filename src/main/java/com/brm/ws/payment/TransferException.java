package com.brm.ws.payment;

import com.brm.ws.payment.types.Fault;

@SuppressWarnings("serial")
public class TransferException extends Exception {

	private Fault fault;

	public TransferException() {
		super();
		fault = new Fault();
		fault.setReason("No message");
	}

	public TransferException(String message) {
		super(message);
	}

	public TransferException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransferException(String message, Fault fault) {
		super(message);
		this.fault = fault;
	}

	public TransferException(String message, Fault fault, Throwable cause) {
		super(message, cause);
		this.fault = fault;
	}

	public Fault getFault() {
		return fault;
	}

}
