package edu.benilde.eat_twenty_four_seven;

public class EatTwentyFourSeven extends Restaurant implements Remindable {
	// Preparable
	@Override
	public void prepare() {
		System.out.println("Preparing orders..");
	}

	// Available
	@Override
	public void welcome() {
		System.out.println("          WELCOME TO          ");
		System.out.println("==============================");
		System.out.println("|       E A T   24 / 7       |");
		System.out.println("==============================");
	}

	// Remindable
	@Override
	public void signUpNote() {
		System.out.println(
				"Please ensure that all the information are correct. \nThe Eat 24/7 will not be liable for due to incorrect information \nand/or non-existent recipient during time of delivery.\n");
	}

	@Override
	public void signUpComplete() {
		System.out.println("\nSign up Process Completed!");
	}

	// error messages
	@Override
	public void noEmptyInput() {
		System.out.println("Empty! It is a required field.");
	}

	@Override
	public void digitsOnly() {
		System.out.println("\nInvalid Entry. Please input digits only.\n");
	}

	@Override
	public void positiveIntegersOnly() {
		System.out.println("\nInvalid Entry. Please input positive digits only.\n");
	}

	// notes
	@Override
	public void dNowNote() {
		System.out.println(
				"\nExpected delivery within 1 hour upon receipt \nof confirmation call from the Eat 24/7 Branch");
	}

	@Override
	public void dLaterNote() {
		System.out.println(
				"\nNOTE:Delivery time is 2 hrs advance from the current time.");
	}

	@Override
	public void paymentDetails() {
		System.out.println("\nPAYMENT OPTIONS");
		System.out.println(
				"Cash Payment Upon Delivery \nPay by depositing the total purchased amount to our assigned bank account.");
		System.out
				.println("\nBank Deposit \nPay by depositing the total purchased amount to our assigned bank account.");
	}

	@Override
	public void paymentOption() {
		System.out.println("\nPlease select preferred payment method to pay your bills.");
		System.out.print("Enter 6 for Cash Payment Upon Delivery \nEnter 9 for Bank Deposit \nEnter 0 to Cancel: ");
	}

	@Override
	public void banks() {
		System.out.println("\nPlease choose from our assigned banks.");
		System.out.println("Enter 1 = BDO \nEnter 2 = RCBC \nEnter 3 = UCPB \nEnter 4 = BPI \nEnter 5 = MetroBank");
	}

	@Override
	public void chooseBank() {
		System.out.print("Bank No. = ");
	}

	@Override
	public void cpudMessage() {
		System.out.println("This confirms that your online transaction is "
				+ "BEING PROCESSED.\nA Eat 24/7 Representative will call "
				+ "your assigned RECIPIENT \nto verify the details of your order.");
		System.out.println("\nThank you so much and we hope to process your order again soon.");
	}

	@Override
	public void bpMessage() {
		System.out.println("Once deposit payment has been confirmed, "
				+ "a Eat 24/7 Representative \nwill call your assigned RECIPIENT to verify the time, "
				+ "date \nand other details of your order.");
		System.out.println("\nThank you so much and we hope to process your order again soon.");
	}

	@Override
	public void exit() {
		System.out.println("\nThank you so much and we hope to process your order again soon.");
	}

	// abstract
	@Override
	public void computeOrders() {
		System.out.println("Computing Orders...\n");
	}

	@Override
	public void prepareReceipt() {
		System.out.println("Preparing Receipt..\n");
	}

}
