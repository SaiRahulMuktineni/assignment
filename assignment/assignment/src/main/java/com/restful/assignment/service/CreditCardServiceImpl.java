package com.restful.assignment.service;

/**
 * Service implementation class to handle the business functionality/logic related to the CreditCard
 */
public class CreditCardServiceImpl implements CreditCardService {

	/**
	 * Method to validate the credit card number
	 */
	@Override
	public boolean validateCreditCard(String cardNumber) {

		double creditCardNumber = Double.parseDouble(cardNumber);
		
		return ((creditCardNumber % 10) %2) == 0 ? true : false; 
	}

}
