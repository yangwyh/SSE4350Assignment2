package assignment2;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		view view = new view();

		boolean loop = true;

		while (loop) {
			System.out.println("Note: \n1.Store student information in a database."
					+ "\n2.Retrieve the student's personal information from the database by the student's Id.");

			System.out.print("\nType 1 for option1, Type 2 for option2:");
			int option = input.nextInt();

			// validity check
			while (option != 1 && option != 2) {
				System.out.println("Invalid input, Please enter 1 or 2 to continue.");
				System.out.println("Type 1 for option1, Type 2 for option2:");
				option = input.nextInt();
			}

			view.displayMenu(option);

			System.out.println("Type 1 to continue, Type 0 to quit.");
			if (input.nextInt() == 1)
				loop = true;
			else
				loop = false;
		}

	}

}