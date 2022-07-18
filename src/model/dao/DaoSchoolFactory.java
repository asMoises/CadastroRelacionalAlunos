package model.dao;

import db.DBConnectionSchool;
import model.dao.impl.GradeDao;
import model.dao.impl.ProgramDao;

public class DaoSchoolFactory {

	public static GradeDaoInterf createGradeDao() {
		return new GradeDao(DBConnectionSchool.getConnection());
	}
	
	public static ProgramDaoInterf createProgramDao() {
		return new ProgramDao(DBConnectionSchool.getConnection());
	}

}
