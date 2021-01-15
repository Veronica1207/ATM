package a01208105.assignment3.data.customers;

import java.util.HashMap;

import a01208105.assignment3.data.accounts.base.Account;

/**
 * Customer data class to hold customer information
 */

/**
 * @version v2.0 2020-06-13
 * @author Bullwinkle Moose & Veronica A01208105
 */
public class Customer {

	private String firstName;
	private String lastName;
	private String passcode;
	private int age;
	private String customerID;
	private HashMap<String, Account> customerAccounts;

	/**
	 * Default constructor for a Customer. Sets the fields to the default values for
	 * each type.
	 */
	public Customer() {
		super();
		customerAccounts = new HashMap<>();
	}

	/**
	 * @param firstName  String to initialize the firstName field
	 * @param lastName   String to initialize the lastName field
	 * @param passcode   String to initialize the passcode field
	 * @param age        Integer to initialize the age field
	 * @param customerID String to initialize the customerID field
	 */
	public Customer(String firstName, String lastName, String passcode, int age, String customerID) {
		super();

		setFirstName(firstName);
		setLastName(lastName);
		setPasscode(passcode);
		setAge(age);
		setCustomerID(customerID);
		customerAccounts = new HashMap<>();
	}

	/**
	 * Accessor for customerAccounts
	 * 
	 * @return the customerAccounts as a HashMap
	 */
	public HashMap<String, Account> getCustomerAccounts() {
		return customerAccounts;
	}

	/**
	 * Mutator for customerAccounts
	 * 
	 * @param customerAccounts the customerAccounts to set
	 */
	public void setCustomerAccounts(HashMap<String, Account> customerAccounts) {
		if (customerAccounts != null) {
			this.customerAccounts = customerAccounts;
		}
	}

	/**
	 * Accessor for a Cutomer's collection of Accounts
	 * 
	 * @return a customer account as an Account
	 */
	public Account getAccount(String accountNumber) {

		return customerAccounts.get(accountNumber);
	}

	/**
	 * Method to add Account filed
	 * 
	 * @param account the Account to set
	 */
	public void addAccount(Account account) {

		if (account != null) {

			customerAccounts.put(account.getAccountNumber(), account);
		}
	}

	/**
	 * Accessor for the getCustomerID field
	 * 
	 * @return the customerID as a String
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * Mutator for the customerID field
	 * 
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		if (customerID != null && !customerID.trim().isEmpty()) {

			this.customerID = customerID;
		} else {
			throw new IllegalArgumentException("ERROR: customerID is a required field");
		}
	}

	/**
	 * Accessor for the age field
	 * 
	 * @return the age as an integer
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Mutator for the age field
	 * 
	 * @param age the age to set
	 */
	public void setAge(int age) {
		if (age > 14) {
			this.age = age;
		} else {
			System.out.println("Sorry, an account holder should be at least 14 y.o.");
		}
	}

	/**
	 * Accessor method for the firstName field
	 * 
	 * @return the firstName as a String
	 */
	public String getFirstName() {

		return firstName;
	}

	/**
	 * Mutator for the firstName field
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {

		if (firstName != null && !firstName.trim().isEmpty()) {
			this.firstName = firstName;
		}
	}

	/**
	 * Accessor method for the lastName
	 * 
	 * @return the lastName as a String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Mutator for the lastName field
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {

		if (lastName != null && !lastName.trim().isEmpty()) {
			this.lastName = lastName;
		}
	}

	/**
	 * Accessor method for the passcode field
	 * 
	 * @return the passcode as a String
	 */
	public String getPasscode() {
		return passcode;
	}

	/**
	 * Mutator for the passcode field
	 * 
	 * @param passcode the passcode to set
	 */
	public void setPasscode(String passcode) {

		if (passcode != null && !passcode.trim().isEmpty()) {
			this.passcode = passcode;
		}
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", passcode=" + passcode + ", age=" + age
				+ ", customerID=" + customerID + ", customerAccounts=" + customerAccounts + "]";
	}

}
