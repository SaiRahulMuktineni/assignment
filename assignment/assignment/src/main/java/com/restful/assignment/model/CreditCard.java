package com.restful.assignment.model;

/**
 * Class to hold information about the credit card details
 *
 */
public class CreditCard {

	/**
	 * Credit card number
	 */
	public String cardNumber;

	/**
	 * Default Constructor
	 */
	public CreditCard() {
		super();
	}

	/**
	 * Parameterized Constructor
	 *
	 * @param cardNumber credit card number
	 */
	public CreditCard(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Return the credit card number
	 *
	 * @return {@link #cardNumber}
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Set the value of credit card number
	 *
	 * @param cardNumber credit card number
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
