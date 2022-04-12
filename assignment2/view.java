package assignment2;

import java.util.Scanner;
import java.sql.SQLException;

public class view {
	public void displayMenu(int option) {
		student stu = new student();
		controller c = new controller(this, stu);
		Scanner sc = new Scanner(System.in);

		if (option == 1) {
			try {
				System.out.println("Enter Student information ");

				System.out.print("Student MatricNo: ");
				int id = sc.nextInt();

				System.out.print("Student Name: ");
				String name = sc.next();

				System.out.print("Student Age: ");
				int age = sc.nextInt();

				System.out.print("Department: ");
				String department = sc.next();

				System.out.print("Nationality: ");
				String nationality = sc.next();

				System.out.print("Math Mark: ");
				double mathMark = sc.nextDouble();

				System.out.print("Science Mark: ");
				double scienceMark = sc.nextDouble();

				c.insertData(id, name, age, department, nationality, mathMark, scienceMark);
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (option == 2) {
			System.out.print("\nEnter Student id: ");
			int id = sc.nextInt();
			try {
				c.getStudent(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void displayStudentMarks(int id, String name, int age, String department, String nationality,
			double mathMark, double scienceMark) {
		System.out.println("\nStudent Marks");
		System.out.println("Student MatricNo: " + id);
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Department: " + department);
		System.out.println("Nationality: " + nationality);
		System.out.println("MathMark: " + mathMark);
		System.out.println("ScienceMark: " + scienceMark);
	}
}