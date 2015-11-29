package edu.benilde.eat_twenty_four_seven;

public interface Remindable {
	
	void signUpNote();

	void prepare();

	void welcome();
	
	void signUpComplete();
	
	//for error messages
	void noEmptyInput();
	
	void digitsOnly();
	
	void positiveIntegersOnly();
	
	//notes
	void dNowNote();
	
	void dLaterNote();
	
	void paymentDetails();
	
	void paymentOption();
	
	void banks();
	
	void chooseBank();
	
	void cpudMessage();
	
	void bpMessage();
	
	void exit();

}
