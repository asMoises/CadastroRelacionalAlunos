package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoSchoolFactory;
import model.dao.GradeDaoInterf;
import model.entities.Grade;

public class GradeDelete {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		GradeDaoInterf gradeDao = DaoSchoolFactory.createGradeDao();
		List<Grade> list = new ArrayList<>();

		System.out.println("\n=== Test Grade Delete ===");
		System.out.print("Enter the Grade Id to be deleted: ");
		int id = sc.nextInt();
		gradeDao.deleteById(id);

		list = gradeDao.findAll();
		for (Grade obj : list) {
			System.out.println(obj);
		}

		sc.close();

	}

}
