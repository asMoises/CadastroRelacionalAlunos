package app;

import java.util.List;

import model.dao.DaoSchoolFactory;
import model.dao.ProgramDaoInterf;
import model.entities.Program;

public class ProgramFindAll {

	public static void main(String[] args) {
		ProgramDaoInterf progDao = DaoSchoolFactory.createProgramDao();

		System.out.println("\n=== Test Find All Programs ===");
		List<Program> list = progDao.findAll();

		for (Program obj : list) {
			System.out.println(obj);
		}

	}

}
