package a01208105.assignment3.storage;

import java.util.HashMap;

import a01208105.assignment3.data.customers.Customer;

/**
 * Bank class.
 * Supports a HashMap of customer accounts.
 */

/**
 * @version v2.0 2020-06-13
 * @author Bullwinkle Moose & Veronica A01208105
 */
public class Bank {

	/**
	 * The bank collection to hold all Customer data. Uses a customer's account
	 * number as key and the Customer reference as the value.
	 */
	public static HashMap<String, Customer> theBank;

	/**
	 * Default constructor for Bank class. Initializes the HashMap
	 */
	public Bank() {
		super();
		theBank = new HashMap<String, Customer>();
	}

	/**
	 * Add a new Customer to the HashMap.
	 * 
	 * @param newCustomer The new element to add to the HashpMap using the account
	 *                    number as the key and the new Customer as the value.
	 */
	public void addCustomer(Customer newCustomer) {

		if (newCustomer != null) {
			theBank.put(newCustomer.getCustomerID(), newCustomer);
		}
	}

	/**
	 * Removes an Customer from the HashMap.
	 * 
	 * @param accountNumber The key of the element to remove from the HashMap.
	 */
	public void closeAccount(String customerID, String accountNumber) {

		if (customerID != null) {
			if (accountNumber != null) {

				theBank.remove(accountNumber);
			}
		}
	}

	/**
	 * Displays the details of a Customer element in the HshMap. Uses
	 * Customer.toString() implementation.
	 * 
	 * @param customer the Customer chosen to display.
	 */
	public static void displayCustomerInformation(Customer customer) {

		if (customer != null) {

			System.out.println(customer);
		}
	}

	/**
	 * Displays all elements of the HashMap by using Customer.toString()
	 * implementation of each.
	 */
	public static void displayAllCustomers() {

		for (Customer customer : theBank.values()) {

			System.out.println(customer);

		}
	}

}
