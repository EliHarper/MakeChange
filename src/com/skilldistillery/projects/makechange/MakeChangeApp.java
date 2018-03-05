package com.skilldistillery.projects.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	static double amountToReturn = 0;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int count = 0;

		System.out.println("How much does the item cost?");
		double price = kb.nextDouble();

		while (true) {
			count++;

			if (count > 1) {
				System.out.println("How much does the item cost?");
				price = kb.nextDouble();
			}

			System.out.println("How much money was tendered by the customer?");
			double amountPaid = kb.nextDouble();

			String leadingStatement = "Give the customer: ";

			while (amountPaid < price) {
				System.err.println("*Squints eyes at customer until they cough up more money*");
				double moreMoneys = kb.nextDouble();
				amountPaid += moreMoneys;
				System.out.println("New total: " + amountPaid);
				System.out.println();
			}

			if (amountPaid > price) {
				amountToReturn = amountPaid - price;
			}

			double change = amountPaid - price;

			System.out.println();
			System.out.println("Change: $" + String.format("%.2f", change));
			System.out.println();
			System.out.println(leadingStatement);
			Twenties();
			Tens();
			Fives();
			Ones();
			Quarters();
			Dimes();
			Nickels();
			Pennies(change);

			System.out.println("\nThank you!");
			System.out.println("Type \"quit\" to quit and anything else to continue.");
			String quitter = kb.next();

			if (quitter.equalsIgnoreCase("quit")) {
				System.out.println("Goodbye!");
				break;
			}

			else {
				continue;
			}
		}
		kb.close();
		// because I am a grownup
	}

	public static void Twenties() {
		if ((int) amountToReturn / 20 > 0) {
			int num = (int) (amountToReturn / 20);
			System.out.print(num + " twent");
			if (num > 1) {
				System.out.println("ies");
			} else {
				System.out.println("y");
			}
		}
		amountToReturn = amountToReturn % 20;
	}

	public static void Tens() {
		if ((int) amountToReturn / 10 > 0) {
			int num = (int) (amountToReturn / 10);
			System.out.println(num + " ten");
			if (num > 1) {
				System.out.print("s");
			}
		}
		amountToReturn = amountToReturn % 10;
	}

	public static void Fives() {
		if ((int) amountToReturn / 5 > 0) {
			int num = (int) (amountToReturn / 5);
			System.out.print(num + " five");
			if (num > 1) {
				System.out.println("s");
			} else {
				System.out.println();
			}
		}
		amountToReturn = amountToReturn % 5;
	}

	public static void Ones() {
		if ((int) amountToReturn / 1 > 0) {
			int num = (int) (amountToReturn / 1);
			System.out.print(num + " one");
			if (num > 1) {
				System.out.println("s");
			} else {
				System.out.println();
			}
		}
		amountToReturn = amountToReturn % 1;
	}

	public static void Quarters() {
		if (amountToReturn / .25 > 0) {
			int num = (int) (amountToReturn / .25);
			if (num > 0) {
				System.out.print(num + " quarter");
				if (num > 1) {
					System.out.println("s");
				} else {
					System.out.println();
				}
			}
		}
		amountToReturn = amountToReturn % .25;
	}

	public static void Dimes() {
		if (amountToReturn / .1 > 0) {
			int num = (int) (amountToReturn / .1);
			if (num > 0) {
				if (num > 1) {
					System.out.println(num + " dimes");
				} else {
					System.out.println(num + " dime");
				}
			}
		}
		amountToReturn = amountToReturn % .1;
	}

	public static void Nickels() {
		if (amountToReturn / .05 > 0) {
			int num = (int) (amountToReturn / .05);
			if (num > 0) {
				if (num > 1) {
					System.out.println(num + " nickels");
				}

				else {
					System.out.println(num + " nickel");
				}
			}
		}
		amountToReturn = amountToReturn % .05;
	}

	public static void Pennies(double change) {
		change = Math.round(change * 100.0)/100.0;
		double pennies = (change*100)%5;
		
	
		if ((int)pennies ==2) {
			System.out.println("2 pennies");
		}
		else if ((int)pennies ==3) {
			System.out.println("3 pennies");
		}
		else if ((int)pennies ==4) {
			System.out.println("4 pennies");
		}
		else if ((int)pennies ==1) {
			System.out.println("1 penny");
		}
		//When I had the pennies method set up like the rest, it was returning incorrect values.
		//The change variable was still correct, so I decided to make the value dependent upon change.
		//With more reflection, I think I found that it was a rounding error; the Math.round method has it working now.

		}
}
