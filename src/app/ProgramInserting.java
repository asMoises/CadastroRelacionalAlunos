package app;

import java.util.Scanner;

import model.dao.DaoSchoolFactory;
import model.dao.ProgramDaoInterf;
import model.entities.Program;

public class ProgramInserting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProgramDaoInterf progDao = DaoSchoolFactory.createProgramDao();

		System.out.println("\n=== Program Inserting ===");
		System.out.print("Enter the program name: ");
		String nameProg = sc.next();
		System.out.print("Enter the program week days: ");
		String weekd = sc.next();

		Program newProg = new Program(null, nameProg, weekd);
		progDao.insert(newProg);

		System.out.println("Inserted! New id: " + newProg.getIdProgram() + ", Program: " + newProg.getProgramName()
				+ ", on " + newProg.getWeekDays());

		sc.close();

	}

}
