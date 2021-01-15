package a01208105.assignment3.data.accounts.derived;

import java.util.Date;

import a01208105.assignment3.data.accounts.base.Account;

import java.text.SimpleDateFormat;

/**
 * This class describes a chequing account
 * 
 * @verion 1.0 2020-06-10
 * @author Veronica
 */
public class ChequingAccount extends Account {

	private final double FEE = 1.5;
	private int numberOfCheques;
	private double totalFees;

	/**
	 * Default constructor
	 */
	public ChequingAccount() {
		super();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param accountNumber   to set the accountNumber field
	 * @param balance         to set the balance field
	 * @param numberOfCheques to set the number of cheques issued
	 * @param totalFees       to set total amount of fees for withdrawal
	 */
	public ChequingAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
		setNumberOfCheques(numberOfCheques);
		setTotalFees(totalFees);
	}

	/**
	 * Accessor for the numberOFCheques field
	 * 
	 * @return the numberOfCheques as an integer
	 */
	public int getNumberOfCheques() {
		return numberOfCheques;
	}

	/**
	 * Accessor for the totalFees field
	 * 
	 * @return totalFees as a double
	 */
	public double getTotalFees() {
		return totalFees;
	}

	/**
	 * Mutator for the totalFees field
	 * 
	 * @param totalFees is total fees amount to set
	 */
	public void setTotalFees(double totalFees) {
		if (totalFees >= 0) {
			this.totalFees = totalFees;
		}
	}

	/**
	 * Mutator for the numberOfCheques field
	 * 
	 * @param numberOfCheques is a number of cheques to set
	 */
	public void setNumberOfCheques(int numberOfCheques) {
		if (numberOfCheques >= 0) {
			this.numberOfCheques = numberOfCheques;
		}
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
			transactionInfo.add(dateString + " " + transaction + "\n    Your current balace: " +  getBalance() + ". Cheques issued: " + numberOfCheques + ". Total Fees: $" + totalFees + "\n");
		}

	}

	/**
	 * Method to subtract an amount from the balance (overriding)
	 * 
	 * @param amount is an amount to withdraw
	 */
	public void subtractFromBalance(double amount) {
		double totalWithdrawal = amount + FEE;

		if (amount > 0) {
			if ((getBalance() - totalWithdrawal) > 0) {
				setBalance(getBalance() - totalWithdrawal);
				numberOfCheques++;
				totalFees = numberOfCheques * FEE;

				addTransactionInfo(" - withdrawal: $" + amount + " + $" + FEE + " withdrawal fee");

			} else {
				System.out.println("You do not have enough funds for the withdrawal.");
				addTransactionInfo(" - withdrawal: $" + amount + " TRANSACTION FAILED");
			}
		}
	}

	/**
	 * Mutator for setAccountNumber field for chequing account (overriding)
	 * 
	 * @param accountNumber is a chequing account number to set
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && !accountNumber.trim().isEmpty()) {
			if (accountNumber.trim().toUpperCase().startsWith("CH-")) {
				this.accountNumber = accountNumber.toUpperCase();
			} else {
				System.out.println("ERROR: incorrect name for Chequing Account");
			}
		} else {
			throw new IllegalArgumentException("ERROR: account number is required");
		}
	}

	@Override
	public String toString() {
		return "ChequingAccount [numberOfCheques=" + numberOfCheques + ", totalFees=" + totalFees + ", toString()="
				+ super.toString() + "]";
	}

}
