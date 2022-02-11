package com.restful.assignment.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.assignment.model.CreditCard;
import com.restful.assignment.service.CreditCardService;
import com.restful.assignment.service.CreditCardServiceImpl;

/**
 * Controller that handles the requests related to CreditCard
 *
 */
@RestController
public class CreditCardController {

	private CreditCardService creditCardService = new CreditCardServiceImpl();
	
	/**
	 * API to validate the credit card number
	 */
	@RequestMapping(value = "/creditcard/validate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON})
	public boolean validateCreditCard(@RequestBody CreditCard creditCard) {
		return creditCardService.validateCreditCard(creditCard.getCardNumber());
	}
}
