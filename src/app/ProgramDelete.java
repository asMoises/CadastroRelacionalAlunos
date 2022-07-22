package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoSchoolFactory;
import model.dao.ProgramDaoInterf;
import model.entities.Program;

public class ProgramDelete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProgramDaoInterf progDao = DaoSchoolFactory.createProgramDao();
		List<Program> list = new ArrayList<>();

		System.out.println("\n=== Test Grade Delete ===");
		System.out.print("Enter the Grade Id to be deleted: ");
		int id = sc.nextInt();
		progDao.deleteById(id);

		list = progDao.findAll();
		for (Program obj : list) {
			System.out.println(obj);
		}

		sc.close();

	}

}
