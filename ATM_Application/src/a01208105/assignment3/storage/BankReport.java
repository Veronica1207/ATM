/**
 * 
 */
package a01208105.assignment3.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import a01208105.assignment3.data.accounts.base.Account;
import a01208105.assignment3.data.customers.Customer;

/**
 * This class generates bank reports
 * 
 * @author Veronica
 * @version 1.0
 */
public class BankReport implements GeneralQueries, FinancialQueries {

	/**
	 * Default constructor
	 */
	public BankReport() {
		super();

	}

	/**
	 * Displays the sum of all account balances in the bank
	 * 
	 * @param theBank holds references of all accounts in the bank
	 */
	@Override
	public void displayAccountTotals(HashMap<String, Customer> theBank) {

		double total = 0.0;
		
		if (theBank != null) {
			for (Customer customer : theBank.values()) {
				for (Account account : customer.getCustomerAccounts().values()) {
					total += account.getBalance();
				}
			}
			System.out.println("Total of all accounts balances: $" + total + "\n");
		}
	}

	/**
	 * Displays the average of all account balances in the bank
	 * 
	 * @param theBank holds references of all accounts in the bank
	 */
	@Override
	public void displayAverageBalance(HashMap<String, Customer> theBank) {
		
		double average = 0.0;
		double total = 0.0;
		int numberOfAccounts = 0;

		if (theBank != null) {
			for (Customer customer : theBank.values()) {
				for (Account account : customer.getCustomerAccounts().values()) {
					total += account.getBalance();
					numberOfAccounts++;
				}
			}
			if (numberOfAccounts != 0) {
				average = total / numberOfAccounts;
				System.out.format("The average of all account balances: $%.2f \n", average);
				System.out.println("(total balance: $" + total + " number of accounts: " + numberOfAccounts + ")\n");
			} else {
				System.out.println("There are no accounts in the Bank" + "\n");
			}
		}

	}

	/**
	 * Displays the sum of all Accounts held by the Customer specified by customer
	 * ID
	 * 
	 * @param theBank    holds references of all accounts in the bank
	 * @param customerID is an ID of a customer
	 */
	@Override
	public void displayBalanceForCustomer(HashMap<String, Customer> theBank, String customerID) {

		double sum = 0.0;
		boolean exit = false;

		if (theBank != null) {
			if (customerID != null && !customerID.trim().isEmpty()) {
				for (Customer customer : theBank.values()) {
					if (customer.getCustomerID().equalsIgnoreCase(customerID)) {
						for (Account account : customer.getCustomerAccounts().values()) {
							sum += account.getBalance();
						}
						System.out.format("%s %s's balance of all accounts combined is $%.2f\n\n",
								customer.getFirstName(), customer.getLastName(), sum);
						exit = true;
					}
				}
				if (exit == false) {
					System.out.println("There are no customers matching this customerID" + "\n");
				}
			} else {
				System.out.println("Customer ID is required" + "\n");
			}
		}
	}

	/**
	 * Displays all accounts of a specific code
	 * 
	 * @param records  is a collection with all accounts in the bank
	 * @param prefixis an account code
	 */
	@Override
	public void displayByCode(HashMap<String, Customer> records, String prefix) {

		ArrayList<String> list = new ArrayList<String>();

		if (records != null) {
			if (prefix != null && !prefix.trim().isEmpty()) {
				for (Customer customer : records.values()) {
					for (Account account : customer.getCustomerAccounts().values()) {
						if (account.getAccountNumber().startsWith(prefix.toUpperCase())) {
							list.add(account.getAccountNumber());
						}
					}
				}
				Collections.sort(list, Collections.reverseOrder());
				String formattedString = list.toString().replace(",", "\n").replace("[", "").replace("]", "").trim();
				System.out.println(" " + formattedString);
			} else {
				System.out.println("Enter an account prefix");
			}
		}

	}

	/**
	 * Displays all active accounts in the bank 
	 * in alphabetic order and sorted by number
	 * 
	 * @param records is a collection with all accounts in the bank
	 */
	@Override
	public void displayAllCodes(HashMap<String, Customer> records) {

		ArrayList<String> list = new ArrayList<String>();

		if (records != null) {

			for (Customer customer : records.values()) {
				for (Account account : customer.getCustomerAccounts().values()) {
					if (account.isActive() == true) {
						list.add(account.getAccountNumber());
					}
				}
			}
			Collections.sort(list, Collections.reverseOrder());
			String formattedString = list.toString().replace(",", "\n").replace("[", "").replace("]", "").trim();
			System.out.println(" " + formattedString);
		}

	}

	/**
	 * Displays all inactive accounts in the bank
	 * 
	 * @param records is a collection with all accounts in the bank
	 */
	@Override
	public void displayInactiveCodes(HashMap<String, Customer> records) {

		ArrayList<String> list = new ArrayList<String>();

		if (records != null) {

			for (Customer customer : records.values()) {
				for (Account account : customer.getCustomerAccounts().values()) {
					if (account.isActive() == false) {
						list.add(account.getAccountNumber());
					}
				}
			}
			Collections.sort(list, Collections.reverseOrder());
			String formattedString = list.toString().replace(",", "\n").replace("[", "").replace("]", "").trim();
			System.out.println(" " + formattedString);
		}

	}

}
