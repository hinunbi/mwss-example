package com.brm.ws.payment;

import com.brm.ws.payment.types.TransferRequest;
import com.brm.ws.payment.types.TransferResponse;

public interface Payment {

	public TransferResponse transferFunds(TransferRequest payload) throws TransferException;

}
