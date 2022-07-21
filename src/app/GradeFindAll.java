package app;

import java.util.List;

import model.dao.DaoSchoolFactory;
import model.dao.GradeDaoInterf;
import model.entities.Grade;

public class GradeFindAll {

	public static void main(String[] args) {

		GradeDaoInterf gradeDao = DaoSchoolFactory.createGradeDao();

		System.out.println("\n=== Test Find All Grades ===");
		List<Grade> list = gradeDao.findAll();

		for (Grade obj : list) {
			System.out.println(obj);
		}
	}

}
