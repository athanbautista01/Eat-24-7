package edu.benilde.eat_twenty_four_seven;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class EatTwentyFourSevenTestDrive {

	protected enum Menu {
		// 1 to 4 appetizer
		// 5 to 12 main dish
		// 13 to 16 soups
		// 17 to 19 salad
		// 20 to 22 pasta
		// 23 to 26 dessert
		NACHOS(1, "Nachos", 400), FRIED_MOZARELLA_STICKS(2, "Fried Mozarella Sticks", 310), CHICKEN_FINGERS(3,
				"Chicken Fingers", 290), CALAMARES_CRUNCH(4, "Calamares Crunch", 375)

		, SINIGANG_BABOY(5, "Sinigang na Baboy", 710), CRISPY_BINAGOONGAN(6, "Crispy Binagoongan", 530), BISTECCA(7,
				"Bistecca", 1910), BEEF_SALPICAO(8, "beef Salpicao", 520), CHICKEN_ALAPOBRE(9, "Chicken Ala Pobre",
						405), KOREAN_BBQ(10, "Korean BBQ", 600), FISH_CHIPS(11, "Fish and Chips",
								620), HICKORY_PORKRIBS(12, "Hickory Pork Ribs", 1200)

		, ASIAN_NOODLE(13, "Asian Noodle Soup", 445), FRESH_MUSHROOM(14, "Fresh Mushroom Soup", 295), SOPA_DE_AJO(15,
				"Sopa De Ajo", 180), CLAM_CHOWDER(16, "Clam Chowder", 315)

		, CAESAR_SALAD(17, "Caesar's Salad", 400), GREEK_GODDESS(18, "Greek Goddess Salad", 400), CRISPY_CATFISH(19,
				"Crispy Catfish Salad", 505)

		, BOLOGNESE(20, "Bolognese", 375), SEAFOOD_PASTA(21, "Seafood Pasta", 490), AGLIO_OLIO(22, "Aglio Olio", 330)

		, FRUIT_PLATTER(23, "Fruit Platter", 320), DESSERT_SAMPLER(24, "Dessert Sampler", 235), MANGO_CREME_BRULEE(25,
				"Mango Creme Brulee", 310), FROZEN_BRAZO(26, "Frozen Brazo", 290);

		protected double price;
		protected int menuNumber;
		protected String menuTitle;

		private Menu(int menuNumber, String menuTitle, double price) {
			this.price = price;
			this.menuNumber = menuNumber;
			this.menuTitle = menuTitle;
		}

		public static Menu getByNumber(int number) {
			for (Menu menu : values()) {
				if (menu.menuNumber == number) {
					return menu;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return menuNumber + " - " + menuTitle + " - " + String.format("P%.2f", price);
		}
	}

	public static void main(String[] args) {

		EatTwentyFourSeven eatTwentyFourSeven = new EatTwentyFourSeven();
		// int i = 10;
		Customer customer = new Customer();
		Recipient recipient = new Recipient();
		Scanner scanner = new Scanner(System.in);
		String deliveryNow = "null";
		String tType = "null";
		boolean keepGoing = true;

		// current date/time
		int day, month, year;
		int second, minute, hour;
		GregorianCalendar date = new GregorianCalendar();

		month = date.get(Calendar.MONTH);
		day = date.get(Calendar.DAY_OF_MONTH);
		year = date.get(Calendar.YEAR);

		second = date.get(Calendar.SECOND);
		minute = date.get(Calendar.MINUTE);
		hour = date.get(Calendar.HOUR_OF_DAY);

		// for receipt file name
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
		String workingDir = System.getProperty("user.dir") + File.separator + "receipts" + File.separator;
		String fileName = "EatTwentyFourSevenReceipt_" + ft.format(dNow) + ".txt";

		/*eatTwentyFourSeven.welcome();

		// sign up
		eatTwentyFourSeven.signUpNote();

		System.out.println("Let's set up first your account.\n NOTE: * is a required field.\n");

		String firstName = "";
		keepGoing = true;
		while (keepGoing) {

			System.out.print("*First Name: ");
			firstName = scanner.nextLine();

			if (!(firstName.equals(""))) {
				keepGoing = false;
				break;
			}
			keepGoing = true;
			eatTwentyFourSeven.noEmptyInput();

		}
		customer.setFirstName(firstName);

		System.out.print("MiddleName: ");
		String middleName = scanner.nextLine();
		customer.setMiddleName(middleName);

		String lastName = "";
		keepGoing = true;
		while (keepGoing) {

			System.out.print("*Last Name: ");
			lastName = scanner.nextLine();

			if (!(lastName.equals(""))) {
				keepGoing = false;
				break;
			}
			keepGoing = true;
			eatTwentyFourSeven.noEmptyInput();

		}
		customer.setLastName(lastName);

		int bYear = 0;
		int bMonth = 0;
		int bDay = 0;
		System.out.println("*BIRTHDAY INFORMATION");

		// Checking
		keepGoing = true;
		while (keepGoing) {

			try {
				System.out.print("Please Enter your Birth Month\n[ex. If January, Enter 1]: ");
				bMonth = scanner.nextInt();

				if (bMonth <= 0 || bMonth > 12) {
					throw new NumberFormatException();
				}

				keepGoing = false;

			} catch (InputMismatchException e) {
				scanner.next();
				eatTwentyFourSeven.digitsOnly();
			} catch (NumberFormatException e) {
				//
				System.out.println("\nInvalid Entry. Please input 1 to 12 only.\n");
			}
		}

		keepGoing = true;
		// Checking
		while (keepGoing) {

			try {
				System.out.print("Please Enter your day of your birth: ");
				bDay = scanner.nextInt();

				if (bDay <= 0 || bDay > 31) {
					throw new NumberFormatException();
				}

				keepGoing = false;
			} catch (InputMismatchException e) {
				scanner.next();
				eatTwentyFourSeven.digitsOnly();
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Entry. Please input valid days of month only.\n");
			}
		}

		keepGoing = true;
		// Checking
		while (keepGoing) {

			try {
				System.out.print("Please Enter your Birth Year[1900 to 2015 only]: ");
				bYear = scanner.nextInt();
				if (bYear <= 1900 || bYear > 2015) {
					throw new NumberFormatException();
				}

				keepGoing = false;
			} catch (InputMismatchException e) {
				scanner.next();
				eatTwentyFourSeven.digitsOnly();
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Entry. Please input valid years only [1900 to 2015 only].\n");
			}
		}

		String birthDate = bMonth + "/" + bDay + "/" + bYear;
		customer.setBirthDate(birthDate);

		String gender = "";
		gender = scanner.nextLine();
		keepGoing = true;
		while (keepGoing) {

			System.out.print("*Gender[M/F]: ");
			gender = scanner.nextLine();

			if (gender.equals("M")) {
				gender = "Male";
				keepGoing = false;
			}
			if (gender.equals("F")) {
				gender = "Female";
				keepGoing = false;
			}
		}
		customer.setGender(gender);

		System.out.print("*Country: ");
		String country = scanner.nextLine();
		customer.setCountry(country);

		System.out.println(
				"*Complete Address[FLOOR/DEPT/BUILDING/HOUSE No., Street, Area/Subdivision/Barangay/District, City/Province]:");
		String completeAddress = scanner.nextLine();
		customer.setCompleteAddress(completeAddress);

		System.out.print("Postal Code: ");
		String postalCode = scanner.nextLine();
		customer.setPostalCode(postalCode);

		long contact = 0L;
		keepGoing = true;
		while (keepGoing) {

			try {
				System.out.print("*Contact No[9XXXXXXXXX or XXXXXXX]: ");
				contact = scanner.nextLong();

				if (contact <= 0) {
					throw new NumberFormatException();
				}

				keepGoing = false;

			} catch (NumberFormatException e) {
				scanner.next();
				eatTwentyFourSeven.positiveIntegersOnly();
			} catch (InputMismatchException e) {
				scanner.next();
				eatTwentyFourSeven.digitsOnly();
			}
		}
		String contactNo = "+63" + contact;
		customer.setContactNo(contactNo);

		System.out.print("*Email: ");
		String email = scanner.nextLine();
		email = scanner.nextLine();
		customer.setEmail(email);

		System.out.print("Confirmation[Re-enter your email]: ");
		String confirmEmail = scanner.nextLine();
		customer.setConfirmEmail(confirmEmail);

		while (true) {
			if (email.equals(confirmEmail)) {
				System.out.println("Emails matched.");
				break;
			} else {
				System.out.println("Email don't match!");

				System.out.print("Confirmation[Re-enter your email]: ");
				confirmEmail = scanner.nextLine();
				customer.setConfirmEmail(confirmEmail);
			}
		}

		System.out.print("*Password: ");
		String password = scanner.nextLine();
		customer.setPassword(password);

		System.out.print("Confirmation: Re-enter your password: ");
		String confirmPassword = scanner.nextLine();
		customer.setConfirmPassword(confirmPassword);

		while (true) {
			if (password.equals(confirmPassword)) {
				System.out.print("Passwords matched.");
				break;
			} else {
				System.out.println("Password don't match!");

				System.out.print("Confirmation: Re-enter your password: ");
				confirmPassword = scanner.nextLine();
				customer.setConfirmPassword(confirmPassword);
			}
		}
		System.out.println();

		eatTwentyFourSeven.signUpComplete();

		System.out.println(customer.getLastName() + ", " + customer.getFirstName() + " " + customer.getMiddleName()
				+ " Informations: \n");

		System.out.println("Full Name: " + customer.getLastName() + ", " + customer.getFirstName() + " "
				+ customer.getMiddleName() + "\nBirthdate: " + customer.getBirthDate() + "\nGender: "
				+ customer.getGender() + "\nComplete Address: " + customer.getCompleteAddress() + ", "
				+ customer.getCountry() + " " + customer.getPostalCode() + "\nContact No: " + customer.getContactNo()
				+ "\nEmail: " + customer.getEmail() + "\nPassword: " + customer.getPassword() + "\n");
*/
		// Delivery Options
		keepGoing = true;
		while (keepGoing) {
			System.out.println("\nPLEASE CHOOSE YOUR PREFERRED ONLINE TRANSACTION TYPE:");
			System.out.print("Press 1 to Delivery Now, 2 to Delivery Later or 0 to Cancel: ");
			tType = scanner.nextLine();

			if (tType.equals("1")) {
				eatTwentyFourSeven.dNowNote();
				deliveryNow = "Within 1 hour after order is placed.";
				keepGoing = false;
				break;
			}
			if (tType.equals("2")) {
				eatTwentyFourSeven.dLaterNote();

				// -Set Delivery Date/Time
				System.out.println("Current Date/Time is  " + (month + 1) + "/" + day + "/" + year + " / " + hour + ":"
						+ minute + ":" + second);
				System.out.println();

				System.out.println("DELIVERY DATE/TIME: \n");

				int tYear = 0;
				int tMonth = 0;
				int tDay = 0;
				int tHour = 0;
				int tMinute = 0;

				// Checking
				while (keepGoing) {

					try {
						System.out.print("Please Enter the Month\n[ex. If January, Enter 1]: ");
						tMonth = scanner.nextInt();

						if (tMonth <= 0 || tMonth > 12) {
							throw new NumberFormatException();
						}
						System.out.print("Please Enter the day: ");
						tDay = scanner.nextInt();

						if (tDay <= 0 || tDay > 31) {
							throw new NumberFormatException();
						}
						System.out.print("Please Enter the Year: ");

						tYear = scanner.nextInt();
						if (tYear <= 2014) {
							throw new NumberFormatException();
						}
						if (tMonth < month && tDay < day && tYear == 2015) {
							throw new NumberFormatException();
						}

						keepGoing = false;

					} catch (InputMismatchException e) {
						scanner.next();
						eatTwentyFourSeven.digitsOnly();
					} catch (NumberFormatException e) {
						System.out.println("\nInvalid Entry. Please input valid month, day & year only.\n");
						System.out.println("Current Date/Time is  " + (month + 1) + "/" + day + "/" + year + " / "
								+ hour + ":" + minute + ":" + second);
					}
				}

				keepGoing = true;
				// Checking
				while (keepGoing) {

					try {
						eatTwentyFourSeven.dLaterNote();
						System.out.print("Please Enter the Hour: ");
						tHour = scanner.nextInt();
						if (tHour < 0 || tHour > 24)  {
							throw new NumberFormatException();
						}
						System.out.print("Please Enter the Minute: ");
						tMinute = scanner.nextInt();
						if (tMinute < 00 || tMinute > 60) {
							throw new NumberFormatException();
						}

						keepGoing = false;

					} catch (InputMismatchException e) {
						scanner.next();
						eatTwentyFourSeven.digitsOnly();
					} catch (NumberFormatException e) {
						System.out.println("\nInvalid Entry. Please input valid time only.\n");
						System.out.println("Current Date/Time is  " + (month + 1) + "/" + day + "/" + year + " / "
								+ hour + ":" + minute + ":" + second);
						eatTwentyFourSeven.dLaterNote();
					}
				}
				System.out.println(
						"Delivery Date/Time is  " + tMonth + "/" + tDay + "/" + tYear + " | " + tHour + ":" + tMinute);

				String deliveryDate = tMonth + "/" + tDay + "/" + tYear + " | " + tHour + ":" + tMinute;
				deliveryNow = deliveryDate;
				keepGoing = false;
				break;
			}
			if (tType.equals("0")) {
				eatTwentyFourSeven.exit();
				System.exit(0);
			}
			keepGoing = true;
		}
		System.out.println("\nInput Recipient's Information: \n");
		// input recipient's info
		String same = "";
		keepGoing = true;
		while (keepGoing) {
			if (tType.equals("2")) {
				System.out.print("Enter 1 for same as Billing Address, \n2 for New Address or 0 to CANCEL: ");
				same = scanner.nextLine();
				same = scanner.nextLine();
			} else {
				System.out.print("Enter 1 for same as Billing Address, \n2 for New Address or 0 to CANCEL: ");
				same = scanner.nextLine();
			}
			if (same.equals("1")) {
				/*recipient.setFirstName(firstName);
				recipient.setLastName(lastName);
				recipient.setGender(gender);
				recipient.setContactNo(contactNo);
				recipient.setCountry(country);
				recipient.setCompleteAddress(completeAddress);
				recipient.setPostalCode(postalCode);*/

				System.out.print("Landmark: ");
				String landmark = scanner.nextLine();
				recipient.setLandmark(landmark);

				System.out.print("Special Instruction/Message: ");
				String specialInstructionOrMessage = scanner.nextLine();
				recipient.setSpecialInstructionOrMessage(specialInstructionOrMessage);
				keepGoing = false;
				break;
			}
			if (same.equals("2")) {
				System.out.println("\nNOTE: * is a required field.\n");

				System.out.print("*First Name: ");
				String firstNameR = scanner.nextLine();
				recipient.setFirstName(firstNameR);

				System.out.print("*Last Name: ");
				String lastNameR = scanner.nextLine();
				recipient.setLastName(lastNameR);

				String genderR = "";
				keepGoing = true;
				while (keepGoing) {

					System.out.print("*Gender[M/F]: ");
					genderR = scanner.nextLine();

					if (genderR.equals("M")) {
						genderR = "Male";
						keepGoing = false;
					}
					if (genderR.equals("F")) {
						genderR = "Female";
						keepGoing = false;
					}
				}
				recipient.setGender(genderR);

				long contactR = 0L;
				keepGoing = true;
				while (keepGoing) {

					try {
						System.out.print("*Contact No[9XXXXXXXXX or XXXXXXX]: ");
						contactR = scanner.nextLong();

						if (contactR <= 0) {
							throw new NumberFormatException();
						}

						keepGoing = false;

					} catch (NumberFormatException e) {
						scanner.next();
						eatTwentyFourSeven.positiveIntegersOnly();
					} catch (InputMismatchException e) {
						scanner.next();
						eatTwentyFourSeven.digitsOnly();
					}
				}
				String contactNoR = "+63" + contactR;
				recipient.setContactNo(contactNoR);

				System.out.print("*Country: ");
				String countryR = scanner.nextLine();
				countryR = scanner.nextLine();
				recipient.setCountry(countryR);

				System.out.println(
						"*Complete Address[FLOOR/DEPT/BUILDING/HOUSE No., Street, Area/Subdivision/Barangay/District, City/Province]:");
				String completeAddressR = scanner.nextLine();
				recipient.setCompleteAddress(completeAddressR);

				System.out.print("Postal Code: ");
				String postalCodeR = scanner.nextLine();
				recipient.setPostalCode(postalCodeR);

				System.out.println("\nNOTE: Additional Informations for delivery.");
				System.out.print("Landmark: ");
				String landmark = scanner.nextLine();
				recipient.setLandmark(landmark);

				System.out.print("Special Instruction/Message: ");
				String specialInstructionOrMessage = scanner.nextLine();
				recipient.setSpecialInstructionOrMessage(specialInstructionOrMessage);
				keepGoing = false;
				break;
			}
			if (same.equals("0")) {
				eatTwentyFourSeven.exit();
				// exit
				System.exit(0);
			}
			keepGoing = true;
		}

		System.out.println("\nDelivery Details: ");

		System.out.println("Full Name: " + recipient.getLastName() + ", " + recipient.getFirstName() + "\nGender: "
				+ recipient.getGender() + "\nComplete Address: " + recipient.getCompleteAddress() + ", "
				+ recipient.getCountry() + " " + recipient.getPostalCode() + "\nContact No: " + recipient.getContactNo()
				+ "\nLandMark: " + recipient.getLandmark() + "\nDelivery Date/Time: " + deliveryNow + "\nRemarks: "
				+ recipient.getSpecialInstructionOrMessage() + "\n");

		String decision = "";
		keepGoing = true;
		while (keepGoing) {
			System.out.print("Enter 1 to Place Order or 0 to CANCEL: ");
			decision = scanner.nextLine();

			if (decision.equals("1")) {
				keepGoing = false;
				break;
			}
			if (decision.equals("0")) {
				eatTwentyFourSeven.exit();
				// exit
				System.exit(0);
			}
			keepGoing = true;
		}

		// order process
		keepGoing = true;
		while (keepGoing) {
			System.out.println("\nHere's our menu.");
			for (Menu menu : Menu.values()) {
				System.out.println(menu);
			}

			System.out.println("\nHow many kinds of food do you want to order? ");
			try {
				int count = scanner.nextInt();

				if (count <= 0) {
					throw new NumberFormatException();
				}

				double sum = 0.0d;
				int input1 = 0;
				int menu = 0;
				keepGoing = false;
				int[] menuCount = new int[count];
				int enumSize = Menu.values().length;

				for (menu = 0; menu < menuCount.length; menu++) {
					keepGoing = true;
					while (keepGoing) {
						System.out.println("\nHere's our menu. Please make your choice: ");
						for (Menu menu1 : Menu.values()) {
							System.out.println(menu1);
						}

						
						System.out.print("\nFood [" + menu + "]: ");
						try {
							menuCount[menu] = scanner.nextInt();

							if (menuCount[menu] <= 0 || menuCount[menu] > enumSize) {
								throw new NumberFormatException();
							}
							
							keepGoing = false;

							if (!keepGoing) {
								keepGoing = true;
								while (keepGoing) {
									Menu menu1 = Menu.getByNumber(menuCount[menu]);
									System.out.println("\nHow many orders of " + menu1.menuTitle + "? ");

									try {
										input1 = scanner.nextInt();

										if (input1 <= 0) {
											throw new NumberFormatException();
										}

										keepGoing = false;
										sum += menu1.price * input1;
									} catch (InputMismatchException e) {
										scanner.next();
										eatTwentyFourSeven.digitsOnly();
									} catch (NumberFormatException e) {
										eatTwentyFourSeven.positiveIntegersOnly();
									}
								}
							}

						} catch (InputMismatchException e) {
							scanner.next();
							eatTwentyFourSeven.digitsOnly();

						} catch (NumberFormatException e) {
							System.out.println("Invalid Entry!");
						} 

					}
				}

				eatTwentyFourSeven.computeOrders();

				System.out.println("\nFoods Tray: \n");

				for (menu = 0; menu < menuCount.length; menu++) {
					Menu menu1 = Menu.getByNumber(menuCount[menu]);
					System.out.print(menuCount[menu] + " - " + menu1.menuTitle + " [" + String.format("PHP %.2f", menu1.price) + "]\n");
				}

				System.out.println("\nTOTAL: " + String.format("PHP %.2f", sum) + "\n");

				eatTwentyFourSeven.prepare();

				// Print billing address, receipt and delivery details

				File myFile = new File(workingDir + fileName);

				try {
					myFile.createNewFile();
				} catch (IOException ee) {
					ee.printStackTrace();
				}

				if (myFile.exists() && myFile.isFile() && myFile.canWrite()) {
					try {

						FileWriter write = new FileWriter(myFile, true);
						// true means file can be appended

						PrintWriter printline = new PrintWriter(write);

						printline.println("Current Date " + (month + 1) + "/" + day + "/" + year + " Current Time "
								+ hour + ":" + minute + ":" + second);

						printline.println("\nBilling Information: ");
						printline.println("Full Name: " + customer.getLastName() + ", " + customer.getFirstName() + " "
								+ customer.getMiddleName());
						printline.println("Birthdate: " + customer.getBirthDate());
						printline.println("Gender: " + customer.getGender());
						printline.println("Complete Address: " + customer.getCompleteAddress() + ", "
								+ customer.getCountry() + " " + customer.getPostalCode());
						printline.println("Contact No: " + customer.getContactNo());
						printline.println("Email: " + customer.getEmail());
						printline.println("----------------------------------------------------------");
						printline.println("Foods Tray: \n");
						for (menu = 0; menu < menuCount.length; menu++) {
							Menu menu1 = Menu.getByNumber(menuCount[menu]);
							printline.println(menuCount[menu] + " - " + menu1.menuTitle + " [" + String.format("PHP %.2f", menu1.price) + "]");
						}
						printline.println("\nTOTAL AMOUNT: " + String.format("PHP %.2f", sum));
						printline.println("----------------------------------------------------------");
						printline.println("Delivery Details: ");
						printline.println("Full Name: " + recipient.getLastName() + ", " + recipient.getFirstName());
						printline.println("Gender: " + recipient.getGender());
						printline.println("Contact No: " + recipient.getContactNo());
						printline.println("Complete Address: " + recipient.getCompleteAddress() + ", "
								+ recipient.getCountry() + " " + recipient.getPostalCode());
						printline.println("LandMark: " + recipient.getLandmark());
						printline.println("Delivery Date: " + deliveryNow);
						printline.println("Remarks: " + recipient.getSpecialInstructionOrMessage());
						printline.println();

						printline.println();

						printline.flush();
						printline.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println(fileName + " does not exist or is not a file or it's locked.");
				}

				keepGoing = true;
				String action = scanner.nextLine();
				while (keepGoing) {

					System.out.print("Enter 1 to Checkout or 0 to Cancel: ");
					action = scanner.nextLine();

					if (action.equals("0")) {
						eatTwentyFourSeven.exit();
						// delete receipt
						File myFile1 = new File(workingDir + fileName);
						try {
							if (myFile1.exists()) {
								myFile1.delete();
								System.out.println(myFile1 + " has been deleted.");
							} else {
								System.out.println("there's nothing to delete");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						// exit
						System.exit(0);
					}
					if (action.equals("1")) {
						
						keepGoing = false;
						break;
					}
					keepGoing = true;
				}

			} catch (InputMismatchException e) {
				scanner.next();
				eatTwentyFourSeven.digitsOnly();

			} catch (NumberFormatException e) {
				eatTwentyFourSeven.positiveIntegersOnly();
			}
		}

		// select payment option
		String trType = "";
		String bankName = "";
		String a = "BDO";
		String b = "RCBC";
		String c = "UCPB";
		String d = "BPI";
		String e = "MetroBank";
		keepGoing = true;
		eatTwentyFourSeven.paymentDetails();
		while (keepGoing) {
			eatTwentyFourSeven.paymentOption();

			trType = scanner.nextLine();

			if (trType.equals("6")) {
				keepGoing = false;
			} else if (trType.equals("9")) {
				eatTwentyFourSeven.banks();
				while (keepGoing) {
					eatTwentyFourSeven.chooseBank();
					bankName = scanner.nextLine();

					if (bankName.equals("1")) {
						bankName = a;
						break;
					} else if (bankName.equals("2")) {
						bankName = b;
						break;
					} else if (bankName.equals("3")) {
						bankName = c;
						break;
					} else if (bankName.equals("4")) {
						bankName = d;
						break;
					} else if (bankName.equals("5")) {
						bankName = e;
						break;
					} else if (!(trType.equals("1,2,3,4,5"))) {
						continue;
					}
					keepGoing = false;
				}

				keepGoing = false;
			}
			if (trType.equals("0")) {
				eatTwentyFourSeven.exit();
				// delete receipt
				File myFile1 = new File(workingDir + fileName);
				try {
					if (myFile1.exists()) {
						myFile1.delete();
						System.out.println(myFile1 + " has been deleted.");
					} else {
						System.out.println("there's nothing to delete");
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				// exit
				System.exit(0);
			}
		}

		// review order
		System.out.println("\nReview Order");

		// Billing
		System.out.println("\nBilling Information: ");

		System.out.println("Full Name: " + customer.getLastName() + ", " + customer.getFirstName() + " "
				+ customer.getMiddleName() + "\nBirthdate: " + customer.getBirthDate() + "\nGender: "
				+ customer.getGender() + "\nComplete Address: " + customer.getCompleteAddress() + ", "
				+ customer.getCountry() + " " + customer.getPostalCode() + "\nContact No: " + customer.getContactNo()
				+ "\nEmail: " + customer.getEmail() + "\nPassword: " + customer.getPassword());

		// Delivery Details
		System.out.println("\nDelivery Details: ");

		System.out.println("Full Name: " + recipient.getLastName() + ", " + recipient.getFirstName() + "\nGender: "
				+ recipient.getGender() + "\nComplete Address: " + recipient.getCompleteAddress() + ", "
				+ recipient.getCountry() + " " + recipient.getPostalCode() + "\nContact No: " + recipient.getContactNo()
				+ "\nLandMark: " + recipient.getLandmark() + "\nDelivery Date: " + deliveryNow + "\nRemarks: "
				+ recipient.getSpecialInstructionOrMessage() + "\n");

		// Final decision SUBMIT or CANCEL
		String finalDecision = "";
		keepGoing = true;
		while (keepGoing) {
			System.out.print("Enter 1 to SUBMIT or 0 to CANCEL: ");
			finalDecision = scanner.nextLine();

			if (finalDecision.equals("1")) {
				keepGoing = false;
				break;
			}
			if (finalDecision.equals("0")) {
				eatTwentyFourSeven.exit();
				// delete receipt
				File myFile1 = new File(workingDir + fileName);
				try {
					if (myFile1.exists()) {
						myFile1.delete();
						System.out.println(myFile1 + " has been deleted.");
					} else {
						System.out.println("there's nothing to delete");
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				// exit
				System.exit(0);
			}
			keepGoing = true;
		}

		keepGoing = true;
		while (keepGoing) {
			if (trType.equals("6")) {
				System.out.println("Thank you for ordering at Eat 24/7, " + customer.getFirstName() + " "
						+ customer.getLastName() + "! \n");

				eatTwentyFourSeven.prepareReceipt();

				System.out.println("Plyease see the order summary with reference number Eat 24/7 \n" + "(placed on "
						+ (month + 1) + "/" + day + "/" + year + " / " + hour + ":" + minute + ":" + second + " ).\n"
						+ "Delivery will be 1 hour after order is placed. \n");
				eatTwentyFourSeven.cpudMessage();

				keepGoing = false;

			} else if (trType.equals("9")) {
				System.out.println("Thank you for ordering at Eat 24/7, " + customer.getFirstName() + " "
						+ customer.getLastName() + "! \n");
				System.out.println("Please see the order summary with reference number Eat 24/7 \n" + "(placed on "
						+ (month + 1) + "/" + day + "/" + year + " / " + hour + ":" + minute + ":" + second + " ).\n"
						+ "Delivery will be on " + deliveryNow);
				System.out.println("\nDEPOSIT INSTRUCTIONS: " + "\nBANK : " + bankName + "\nREFRENCE NO. : BRESTO000000"
						+ "\nACCOUNT NO. : 123-4-56788765-9" + "\nACCOUNT NAME : Eat 24/7 Inc."
						+ "\nACCOUNT TYPE : Savings Account" + "\nAMOUNT : Php 0.00");
				System.out.println(
						"\nThis confirms that you have choosen to pay your online \ntransaction through bank deposit BANK DEPOSIT. \n");
				eatTwentyFourSeven.bpMessage();
				keepGoing = false;
			} else if (!(trType.equals("6,9"))) {
				eatTwentyFourSeven.exit();
				// delete receipt
				File myFile1 = new File(workingDir + fileName);
				try {
					if (myFile1.exists()) {
						myFile1.delete();
						System.out.println(myFile1 + " has been deleted.");
					} else {
						System.out.println("there's nothing to delete");
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				// exit
				System.exit(0);
			}
		}
	}

	// private static int readNumberInput(Scanner scanner) {
	// try {
	// return scanner.nextInt();
	// } catch (InputMismatchException ex) {
	// String inputString = scanner.next();
	// System.out.println("Input [" + inputString + "] was not correct. Please
	// choose a number.");
	// return 0;
	// }
	// }

}