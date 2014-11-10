package com.brm.ws.payment;

import com.brm.ws.payment.types.Fault;
import com.brm.ws.payment.types.TransferRequest;
import com.brm.ws.payment.types.TransferResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPayment implements Payment {

	private static final Logger logger = LoggerFactory.getLogger(DefaultPayment.class);

	private long MAX_TRANSFER_AMOUNT = 1000000;

	@Override
	public TransferResponse transferFunds(TransferRequest request) throws TransferException {

		TransferResponse response = new TransferResponse();

		if (request.getAmount() > MAX_TRANSFER_AMOUNT) {
			String reason = String.format("이체 한도 금액 초과: 이체 요청 금액(%d)", request.getAmount());
			Fault fault = new Fault();
			fault.setReason(reason);
			TransferException faultMessage = new TransferException("이체 오류", fault);
			logger.warn(reason, faultMessage);
			throw faultMessage;
		} else {
			response.setReply("OK");
		}

		return response;
	}
}
