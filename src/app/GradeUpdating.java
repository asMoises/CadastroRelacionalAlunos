package app;

import java.util.Scanner;

import model.dao.DaoSchoolFactory;
import model.dao.GradeDaoInterf;
import model.entities.Grade;

public class GradeUpdating {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GradeDaoInterf gradeDao = DaoSchoolFactory.createGradeDao();

		System.out.println("=== Testing Grade Update ===");
		System.out.print("Enter the ID Grade: ");
		int idGrade = sc.nextInt();

		Grade grade = gradeDao.findById(idGrade);
		System.out.print("Enter the new grade name: " + grade.getGradeName());
		String newGradeName = sc.next();
		sc.nextLine();
		grade.setGradeName(newGradeName);
		gradeDao.update(grade);
		gradeDao.findById(grade.getIdGrade());
		System.out.println(grade);

		sc.close();

	}

}
