package a01208105.assignment3.app;

import a01208105.assignment3.data.accounts.base.Account;
import a01208105.assignment3.data.accounts.derived.ChequingAccount;
import a01208105.assignment3.data.accounts.derived.GoldAccount;
import a01208105.assignment3.data.accounts.derived.SavingsAccount;
import a01208105.assignment3.data.customers.Customer;
import a01208105.assignment3.storage.Bank;
import a01208105.assignment3.storage.BankReport;

/**
 * ATM class, The COMP 1451 Assignment application driver
 */

/**
 * @version v2.0 2020-06-13
 * @author Bullwinkle Moose & Veronica A01208105
 */
public class ATM {

	private InputReader reader;
	private String accountNumber;
	private String passcode;
	private boolean customerVerified;
	private String customerID;
	private BankReport bankReports;

	private Bank theBank;
	private Customer currentCustomer;

	private final int GOLD_AGE = 65;

	/**
	 * Default constructor. Calls the initialize() method to seed the Bank with some
	 * Customers. Calls the run() method to perform the primary program functions.
	 */
	public ATM() {
		super();
		initialize();
		run();
	}

	/**
	 * Main method calls the class default constructor.
	 * 
	 * @param args for program arguments (not used)
	 */
	public static void main(String[] args) {

		new ATM();

	}

	/**
	 * The primary application processor. All application functions are called from
	 * here. Uses a loop to prompt users to perform banking transactions. Must use
	 * switch/case selection to determine uses choices.
	 */
	public void run() {

		reader = new InputReader();
		boolean exit = false;

		System.out.println("Welcome to Bullwinkle's Bank.");

		while (!exit) {
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
			System.out.print("> ");
			int choice = reader.getIntInput();

			switch (choice) {

			case 1:
				choice = 1;
				verifyCustomer();
				break;
			case 2:
				choice = 2;
				transactDeposit();
				break;
			case 3:
				choice = 3;
				transactWithdraw();
				break;
			case 4:
				choice = 4;
				displayAccountInformation();
				break;
			case 5:
				choice = 5;

				if (currentCustomer != null) {
					currentCustomer.getAccount(accountNumber).displayAccountRecords();
				}

				System.out.println("Thank you for banking at Bullwinkle's Bank");
				System.out.println("DEBUG: Displaying all the accounts in the bank.");
				Bank.displayAllCustomers();
				System.exit(0);

			}

		}

	}
	
	public void runEmployee() {
		
		boolean exit = false;
		while (!exit) {
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Display by Code");
			System.out.println("2 - Display all Active Codes");
			System.out.println("3 - Display all Inactive Codes");
			System.out.println("4 - Display Accounts Total");
			System.out.println("5 - Display Average Balance");
			System.out.println("6 - Display Balance for Customer");
			System.out.println("7 - Exit");
			System.out.print("> ");
			int choice = reader.getIntInput();

			switch (choice) {

			case 1:
				choice = 1;
				String prefix = null;
				System.out.println("Enter account prefix: ");
				prefix = reader.getStringInput();				
				bankReports.displayByCode(Bank.theBank, prefix);
				break;
			case 2:
				choice = 2;
				bankReports.displayAllCodes(Bank.theBank);
				break;
			case 3:
				choice = 3;
				bankReports.displayInactiveCodes(Bank.theBank);
				break;
			case 4:
				choice = 4;
				bankReports.displayAccountTotals(Bank.theBank);
				break;
			case 5:
				choice = 5;
				bankReports.displayAverageBalance(Bank.theBank);
				break;
			case 6:
				choice = 6;
				System.out.println("Enter CustomerID: ");
				customerID = reader.getStringInput();
				bankReports.displayBalanceForCustomer(Bank.theBank, customerID);
				break;
			case 7:
				choice = 7;
				
				System.out.println("DEBUG: Displaying all the accounts in the bank.");
				Bank.displayAllCustomers();
				System.exit(0);

			}

		}

	}

	/**
	 * Creates Customer objects by calling overloaded constructor. creates Account
	 * objects by calling overloaded constructor. Sets Accounts to Customers. Adds
	 * Customer references to the Back HashMap as seed data for testing.
	 */
	public void initialize() {

		theBank = new Bank();
		bankReports = new BankReport();

		Customer brady = new Customer("Brady", "Dog", "123", 23, "B12345");
		Account savings1 = new SavingsAccount("sa-123", 0.0);
		Account savings2 = new SavingsAccount("sa-532", 100.0);
		Account chequing1 = new ChequingAccount("ch-123", 0.0);
		brady.addAccount(savings1);
		brady.addAccount(savings2);
		brady.addAccount(chequing1);
		if (brady.getAge() >= GOLD_AGE) {
			brady.addAccount(new GoldAccount("GL-789", 200.0));
		} else {
			System.err.println(brady.getFirstName() + " not old enough to hold a GoldAccount.");
		}

		theBank.addCustomer(brady);

		Customer myia = new Customer("Myia", "Dog", "456", 67, "B67891");
		Account savings3 = new SavingsAccount("SA-456", 350.0);
		Account chequing2 = new ChequingAccount("CH-456", 0.0);
		Account gold1 = new GoldAccount("gL-456", 2000.0);
		myia.addAccount(savings3);
		myia.addAccount(chequing2);

		if (myia.getAge() >= GOLD_AGE) {
			myia.addAccount(gold1);
		} else {
			System.err.println(myia.getFirstName() + " not old enough to hold a GoldAccount.");
		}

		theBank.addCustomer(myia);

		Customer freckle = new Customer("Freckle", "Cat", "789", 33, "B23456");
		Account savings4 = new SavingsAccount("sa-789", 0.0);
		Account chequing3 = new ChequingAccount("ch-789", 450.0);
		freckle.addAccount(savings4);
		freckle.addAccount(chequing3);

		if (freckle.getAge() >= GOLD_AGE) {
			freckle.addAccount(new GoldAccount("GL-634", 100.0));
		} else {
			System.err.println(freckle.getFirstName() + " not old enough to hold a GoldAccount.");
		}

		theBank.addCustomer(freckle);
		
		Customer leify = new Customer("Leify", "Good-Boy", "111", 70, "B11111");
		Account savings5 = new SavingsAccount("SA-111", 800.0);
		Account savings6 = new SavingsAccount("SA-235", 0.0);
		Account chequing4 = new ChequingAccount("ch-438", 0.0);
		Account gold5 = new GoldAccount("GL-111", 2000.0);
		Account gold6 = new GoldAccount("GL-642", 0.0);
		leify.addAccount(savings5);
		leify.addAccount(savings6);
		leify.addAccount(chequing4);
		
		if (leify.getAge() >= GOLD_AGE) {
			leify.addAccount(gold5);
			leify.addAccount(gold6);
		} else {
			System.err.println(leify.getFirstName() + " not old enough to hold a GoldAccount.");
		}
		
		theBank.addCustomer(leify);
		savings5.setActive(false);
		savings6.setActive(false);
		gold5.setActive(false);	
		gold6.setActive(false);
		chequing4.setActive(false);
	}

	/**
	 * Performs a deposit into a Customer's account. Checks to see if the customer
	 * has signed in. If not, then verifyCustomer() is called and the menu is
	 * displayed again.
	 */
	public void transactDeposit() {

		if (customerVerified) {
			System.out.println("Enter the amount to deposit: ");
			double amount = 0;
			amount = reader.getDoubleInput();

			currentCustomer.getAccount(accountNumber).addToBalance(amount);
			currentCustomer.getAccount(accountNumber).addTransactionInfo(" - deposit: $" + amount);

		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}
	}

	/**
	 * Performs a withdrawal from a Customer's account. Checks to see if the
	 * customer has signed in. If not, then verifyCustomer() is called and the menu
	 * is displayed again.
	 */
	public void transactWithdraw() {

		if (customerVerified) {
			System.out.println("Enter the amount to withdraw: ");
			double amount = 0;
			amount = reader.getDoubleInput();

			currentCustomer.getAccount(accountNumber).subtractFromBalance(amount);

		} else {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}

	}

	/**
	 * Displays a Customer's information if the customer has been previously
	 * verified.
	 */
	public void displayAccountInformation() {

		if (customerVerified) {
			System.out.println("Here is your information.");
			Bank.displayCustomerInformation(currentCustomer);
		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}

	}

	/**
	 * Confirms a Customer's account number and passcode. Called when the user is
	 * required to sign in to the application. Will set a boolean so the user does
	 * not have to sign in again during the session.
	 */
	public void verifyCustomer() {

		System.out.println("Enter CustomerID: ");
		customerID = reader.getStringInput();

		if (customerID != null) {

			if (customerID.equalsIgnoreCase("admin")) {
				System.out.println("Enter Passcode: ");
				passcode = reader.getStringInput();

				if (passcode.equalsIgnoreCase("admin")) {
					runEmployee();
				}
			} else {

				currentCustomer = Bank.theBank.get(customerID);

				if (currentCustomer != null) {

					for (String temp : currentCustomer.getCustomerAccounts().keySet()) {
						System.out.println(temp);
					}

					System.out.println("Enter Account Number: ");
					accountNumber = reader.getStringInput();
					System.out.println("Enter Passcode: ");
					passcode = reader.getStringInput();

					if (passcode.equals(currentCustomer.getPasscode())) {
						for (String temp : currentCustomer.getCustomerAccounts().keySet()) {
							if (accountNumber.equals(temp)) {
								customerVerified = true;
							}
						}
					}

					if (customerVerified == false) {
						System.out.println("ERROR: password or account is not correct.");
						run();
					}

				} else {
					System.out.println("ERROR: customerID is not correct.");
					run();
				}
			}
		}

	}
}
