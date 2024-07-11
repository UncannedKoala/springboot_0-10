package com.learining.springboot.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.learining.springboot.model.Payment;
import com.learining.springboot.proxy.PaymentsProxy;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
	private final PaymentsProxy paymentProxy;

	public PaymentController(PaymentsProxy paymentProxy) {
		this.paymentProxy = paymentProxy;
	}
	
	@PostMapping("/payment")
	public Payment sendPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
		logger.info("Recieved request with ID: " + requestId + " ;Payment amount: " + payment.getAmount());
		payment.setId(UUID.randomUUID().toString());
		return paymentProxy.createPayment(requestId, payment);
	}

}
