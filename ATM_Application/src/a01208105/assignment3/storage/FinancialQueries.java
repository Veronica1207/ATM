package a01208105.assignment3.storage;

import java.util.HashMap;

import a01208105.assignment3.data.customers.Customer;

/**
 * This is an interface for BankReport objects
 * 
 * @author Veronica
 * @version 1.0
 */
public interface FinancialQueries {
	
	/**
	 * Displays the dollar value which is the sum of all account balances in the bank
	 * @param theBank holds references of all accounts in the bank 
	 */ 
	void displayAccountTotals(HashMap<String, Customer> theBank);
	
	/**
	 * Displays the dollar value which is the average of all account balances in the bank 
	 * @param theBank holds references of all accounts in the bank 
	 */
	void displayAverageBalance(HashMap<String, Customer> theBank);
	
	/**
	 * Displays the dollar value of the sum of all Accounts held by the Customer specified by customer ID
	 * @param theBank holds references of all accounts in the bank 
	 * @param customerID is an ID of a customer
	 */
	void displayBalanceForCustomer(HashMap<String, Customer> theBank, String customerID);

}
