package app;

import java.util.Scanner;

import model.dao.DaoSchoolFactory;
import model.dao.GradeDaoInterf;
import model.entities.Grade;

public class TestingGrade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GradeDaoInterf gradeDao = DaoSchoolFactory.createGradeDao();

		System.out.println("=== Testing Grade findById ===");
		System.out.print("Enter the ID Grade: ");
		int idGrade = sc.nextInt();

		Grade grade = gradeDao.findById(idGrade); // this guy returns a Grade object finding by ID
		System.out.println(grade);

		sc.close();
	}

}
