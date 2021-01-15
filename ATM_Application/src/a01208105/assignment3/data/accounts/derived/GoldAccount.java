package a01208105.assignment3.data.accounts.derived;

import java.util.Date;

import a01208105.assignment3.data.accounts.base.Account;

import java.text.SimpleDateFormat;

/**
 * This class describes a gold account
 * 
 * @verion 1.0 2020-06-10
 * @author Veronica
 */
public class GoldAccount extends Account {

	private double interestRate;
	private boolean isOverdraft;
	private final double FEE = 7.5;
	private final double OVERDRAFT_AMT = -1000;

	/**
	 * Default constructor
	 */
	public GoldAccount() {
		super();

	}

	/**
	 * Overloaded constructor
	 * 
	 * @param accountNumber to set the accountNumber field
	 * @param balance       to set the balance field
	 * @param isOverdraft   to set whether the account is in overdraft or not
	 * @param interestRate  to set an interestRate field
	 */
	public GoldAccount(String accountNumber, double balance) {
		super(accountNumber, balance);

		this.interestRate = 2.5;
		isOverdraft = false;
	}

	/**
	 * Accessor for the interestRate field
	 * 
	 * @return the interestRate as adouble
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * Mutator for the interestRate field
	 * 
	 * @param interestRate is the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		if (interestRate >= 0) {
			this.interestRate = interestRate;
		}
	}

	/**
	 * Accessor for the isOverdraft field
	 * 
	 * @return the isOverdraft as a boolean
	 */
	public boolean isOverdraft() {
		return isOverdraft;
	}

	/**
	 * Mutator for the isOverdraft field
	 * 
	 * @param isOverdraft the isOverdraft to set
	 */
	public void setOverdraft(boolean isOverdraft) {
		this.isOverdraft = isOverdraft;
	}
	
	/**
	 * Method to add information about transactions made
	 * 
	 * @param transaction is an information about the transaction that needs to be
	 *                    displayed
	 */
	public void addTransactionInfo(String transaction)	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
		String dateString = sdf.format(date);
		
		double availableOVDRFT = 0;
		availableOVDRFT = 90;
		if(getBalance() >= 0) {
			availableOVDRFT = OVERDRAFT_AMT;
		} else {
			availableOVDRFT = OVERDRAFT_AMT - getBalance();
		}	

		if (transaction != null && !transaction.trim().isEmpty()) {
			transactionInfo.add(dateString + " " + transaction + "\n    Your current balace: " +  getBalance() + ". Available overdraft: " + availableOVDRFT + "\n");
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
			if ((getBalance() - totalWithdrawal) > OVERDRAFT_AMT) {

				if (isOverdraft == false) {
					if (getBalance() > 0 && (getBalance() - amount) < 0) {
						setBalance(getBalance() - totalWithdrawal);
						setOverdraft(true);
						addTransactionInfo(" - withdrawal: $" + totalWithdrawal + " ($" + FEE + " overdraft fee applies)");
					} else {
						setBalance(getBalance() - amount);
						addTransactionInfo(" - withdrawal: $" + amount);
					}
				} else {
					setBalance(getBalance() - amount);
					addTransactionInfo(" - withdrawal: $" + amount);
				}

			} else {
				System.out.println("You do not have enough funds for the withdrawal.");
				addTransactionInfo(" - withdrawal: $" + amount + " TRANSACTION FAILED");
			}
		}
	}
	
	/**
	 * Mutator for the setAccountNumber field for gold accounts (overriding)
	 * 
	 * @param accountNumber is an account number to set for gold accounts
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && !accountNumber.trim().isEmpty()) {
			if (accountNumber.trim().toUpperCase().startsWith("GL-")) {
				this.accountNumber = accountNumber.toUpperCase();
			} else {
				System.out.println("ERROR: incorrect name for Gold Account");
			}
		} else {
			throw new IllegalArgumentException("ERROR: account number is required");
		}
	}
	
	

	@Override
	public String toString() {
		return "GoldAccount [interestRate=" + interestRate + ", isOverdraft=" + isOverdraft + ", toString()="
				+ super.toString() + "]";
	}

}
