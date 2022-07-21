package app;

import java.util.Scanner;

import model.dao.DaoSchoolFactory;
import model.dao.GradeDaoInterf;
import model.entities.Grade;

public class GradeInserting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GradeDaoInterf gradeDao = DaoSchoolFactory.createGradeDao();

		System.out.println("\n=== Grade Inserting ===");
		System.out.print("Enter the grade name: ");
		String name = sc.nextLine();
		
		Grade newGrade = new Grade(null, name);
		gradeDao.insert(newGrade);

		System.out.println("Inserted! New id: " + newGrade.getIdGrade() + ", Grade: " + newGrade.getGradeName());

		sc.close();

	}

}
