package a01208105.assignment3.data.accounts.base;

import java.util.ArrayList;

/**
 * This is a superclass to hold information about a bank account
 * abstract class
 */

/**
 * @version 2.0 2020-06-10
 * @author Bullwinkle Moose & Veronica A01208105
 */
public abstract class Account {

	protected String accountNumber; // protected modifier for overriding the setAccountNumber method
	private double balance;
	private boolean active;
	protected ArrayList<String> transactionInfo;

	/**
	 * Default constructor to create Account objects
	 */
	public Account() {
		super();
		transactionInfo = new ArrayList<String>();
	}

	/**
	 * Overloaded Account constructor
	 * 
	 * @param accountNumber to set the accountNumber field
	 * @param balance       to set the balance field
	 * @param active        to set the active field;
	 * @param transaction   info is an ArrayList of Strings to initialize
	 */
	public Account(String accountNumber, double balance) {
		super();
		setAccountNumber(accountNumber);
		setBalance(balance);
		active = true;
		transactionInfo = new ArrayList<String>();
	}

	/**
	 * Accessor for the accountNumber field
	 * 
	 * @return the accountNumber as a String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Accessor for the balance field
	 * 
	 * @return the balance as a double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Accessor for the active field
	 * 
	 * @return the active as a boolean
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Mutator for the accountNumber field
	 * 
	 * @param the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && !accountNumber.trim().isEmpty()) {
			this.accountNumber = accountNumber;
		} else {
			throw new IllegalArgumentException("ERROR: account number is required");
		}
	}

	/**
	 * Mutator for the balance field
	 * 
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Mutator for the active field
	 * 
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Accessor for transactionInfo field
	 * 
	 * @return the transactions as an ArrayList
	 */
	public ArrayList<String> getTransactions() {
		return transactionInfo;
	}

	/**
	 * Mutator for the transactionInfo field
	 * 
	 * @param transactionInfo the transactionInfo to set
	 */
	public void setTransactions(ArrayList<String> transactionInfo) {
		if (transactionInfo != null) {
			this.transactionInfo = transactionInfo;
		} else {
			System.out.println("List of transactions is emplty");
		}
	}

	/**
	 * Adds to an Account balance
	 * 
	 * @param amount a double to add to the existing balance field
	 */
	public void addToBalance(double amount) {

		if (amount > 0) {
			balance += amount;

		}
	}

	/**
	 * Method to display all account records(transactions) that were made
	 */
	public void displayAccountRecords() {

		System.out.println("Account Activity:");

		for (String transaction : transactionInfo) {
			if (transaction != null) {
				System.out.println(transaction);
			}
		}
	}
	
	/**
	 * Subtracts from an Account balance
	 * 
	 * @param amount a double to subtract from the balance field
	 */
	public abstract void subtractFromBalance(double amount);

	/**
	 * Method to add information about transactions made
	 * 
	 * @param transaction is an information about the transaction that needs to be
	 *                    displayed
	 */

	public abstract void addTransactionInfo(String transaction);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", active=" + active + "]";
	}

}
