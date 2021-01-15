/**
 * 
 */
package a01208105.assignment3.storage;

import java.util.HashMap;

import a01208105.assignment3.data.customers.Customer;

/**
 * This is an interface for BankReport objects
 * 
 * @author Veronica
 * @version 1.0
 */
public interface GeneralQueries {

	/**
	 * Displays all accounts of a specific code
	 * @param records is a collection with all accounts in the bank 
	 * @param prefixis an account code
	 */ 
	void displayByCode(HashMap<String, Customer> records, String prefix);
	
	/**
	 * Displays all active accounts in the bank
	 * in alphabetic order and sorted by number
	 * @param records is a collection with all accounts in the bank 
	 */
	void displayAllCodes(HashMap<String, Customer> records);
	
	/**
	 * Displays all inactive accounts in the bank
	 * @param records is a collection with all accounts in the bank 
	 */
	void displayInactiveCodes(HashMap<String, Customer> records);

}
