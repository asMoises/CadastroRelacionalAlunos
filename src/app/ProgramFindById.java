package app;

import java.util.Scanner;

import model.dao.DaoSchoolFactory;
import model.dao.ProgramDaoInterf;
import model.entities.Program;

public class ProgramFindById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ProgramDaoInterf progDao = DaoSchoolFactory.createProgramDao();

		System.out.println("=== Testing Program findById ===");
		System.out.print("Enter the ID Program: ");
		int idProgram = sc.nextInt();

		Program program = progDao.findById(idProgram);
		System.out.println(program);

		sc.close();

	}

}
