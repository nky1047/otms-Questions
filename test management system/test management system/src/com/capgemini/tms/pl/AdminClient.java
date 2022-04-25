package com.capgemini.tms.pl;

import java.sql.SQLException;
import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;

public class AdminClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ch = "yes";

		TestService service = null;
		QuestionService service1 = null;

		try {
			service = new TestServiceImpl();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println(e1.getMessage());
		}

		try {
			service1 = new QuestionServiceImpl();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println(e1.getMessage());
		}

		while (ch.equalsIgnoreCase("yes")) {
			System.out.println("Select Operation");
			System.out.println("1.Add Test");
			System.out.println("2.Delete Test");
			System.out.println("3.Add question");
			System.out.println("4.Delete Question");
			System.out.println("5.Update question");
			System.out.println("6.Get result ");
			System.out.println("7.register User");

			int op = sc.nextInt();

			switch (op) {
			case 1:
				try {
					service.addTest();
				} catch (SQLException | TestException e1) {
					System.err.println(((Throwable) e1).getMessage());
					((Throwable) e1).printStackTrace();
				}
				break;
			case 2:
				try {
					service.deleteTest();
				} catch (SQLException | TestException e1) {
					System.err.println(((Throwable) e1).getMessage());
					((Throwable) e1).printStackTrace();
				}
				break;
			case 3:
				try {
					service1.addQuestion();
				} catch (SQLException | QuestionException e1) {
					System.err.println(((Throwable) e1).getMessage());
					((Throwable) e1).printStackTrace();
				}
				break;

			case 4:
				try {
					service1.deleteQuestion();
				} catch (SQLException | QuestionException e1) {
					System.err.println(((Throwable) e1).getMessage());
					((Throwable) e1).printStackTrace();
				}
				break;
			case 5:
				try {
					service1.updateQuestion();
				} catch (SQLException | QuestionException e1) {
					System.err.println(((Throwable) e1).getMessage());
					((Throwable) e1).printStackTrace();
				}
				break;
			case 6:
				try {
					service.getResult();
				} catch (SQLException | TestException e1) {
					System.err.println(((Throwable) e1).getMessage());
					((Throwable) e1).printStackTrace();
				}
				break;
			default:
				break;
			}

			System.out.println("Continue yes\\not");
			ch = sc.next();
		}

	}
}
