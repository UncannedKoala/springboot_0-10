package com.learining.springboot.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.learining.springboot.model.Payment;

@Component
public class RestPaymentProxy {

	private final RestTemplate template;

	@Value("${name.service.url}")
	private String PaymentsServiceUrl;

	public RestPaymentProxy(RestTemplate template) {
		this.template = template;
	}

	/**
	 * HttpHeaders come from Spring since RestTemplate is a part of Spring.web
	 * @param Payment
	 * @return Payment object on successful execution
	 */
	public Payment createPayment(Payment payment) {
		String uri = PaymentsServiceUrl + "/payment";
		HttpHeaders headers = new HttpHeaders();
		headers.add("requestId", UUID.randomUUID().toString());

		HttpEntity<Payment> httpEntity = new HttpEntity<Payment>(payment, headers);
		HttpEntity<Payment> responseEntity = template.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
		return responseEntity.getBody();
	}
}
