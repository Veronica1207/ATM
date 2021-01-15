package a01208105.assignment3.data.accounts.derived;

import java.util.Date;

import a01208105.assignment3.data.accounts.base.Account;

import java.text.SimpleDateFormat;

/**
 * This class describes a savings account
 * 
 * @verion 1.0 2020-06-10
 * @author Veronica A01208105
 *
 */
public class SavingsAccount extends Account {

	private final double MIN_AMOUNT = 25.0;

	/**
	 * Default constructor
	 */
	public SavingsAccount() {
		super();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param accountNumber to set the accountNumber field
	 * @param balance       to set the balance field
	 */
	public SavingsAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

	/**
	 * Method to add information about transactions made
	 * 
	 * @param transaction is an information about the transaction that needs to be
	 *                    displayed
	 */
	public void addTransactionInfo(String transaction) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
		String dateString = sdf.format(date);

		if (transaction != null && !transaction.trim().isEmpty()) {

			transactionInfo.add(dateString + " " + transaction + "\n    Your current balace: " + getBalance()
					+ ". REMINDER: Your minimum required balance: " + MIN_AMOUNT + ".\n");

			if (isActive() == false) {
				
				System.out.println("You went over the minimum balance. No further withdrawals allowed.");
			}

		}
	}

	/**
	 * Method to subtract an amount from the balance (overriding)
	 * 
	 * @param amount is an amount to withdraw
	 */
	public void subtractFromBalance(double amount) {
		if (amount > 0) {
			if (isActive() == true) {

				setBalance(getBalance() - amount);

				if (getBalance() < MIN_AMOUNT) {
					setActive(false);
				}

				addTransactionInfo(" - withdrawal: $" + amount);

			} else {
				addTransactionInfo(" - withdrawal: $" + amount + " TRANSACTION FAILED");
			}
		}
	}

	/**
	 * Method to add to balance and set account to active when out of a negative
	 * balance (overriding)
	 * 
	 * @param amount is an amount to add to the balance
	 */
	public void addToBalance(double amount) {

		if (amount > 0) {
			setBalance(getBalance() + amount);

			if (getBalance() > MIN_AMOUNT) {
				setActive(true);
			}
		}
	}

	/**
	 * Mutator for setAccountNumber field for savings account (overriding)
	 * 
	 * @param accountNumber is a savings account number to set
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && !accountNumber.trim().isEmpty()) {
			if (accountNumber.trim().toUpperCase().startsWith("SA-")) {
				this.accountNumber = accountNumber.toUpperCase();
			} else {
				System.out.println("ERROR: incorrect name for Savings Account");
			}
		} else {
			throw new IllegalArgumentException("ERROR: account number is required");
		}
	}

	@Override
	public String toString() {
		return "SavingsAccount [toString()=" + super.toString() + "]";
	}
}
