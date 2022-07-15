package model.dao;

import db.DBConnectionSchool;
import model.dao.impl.GradeDao;

public class DaoSchoolFactory {

	public static GradeDaoInterf createGradeDao() {
		return new GradeDao(DBConnectionSchool.getConnection());
	}

}
