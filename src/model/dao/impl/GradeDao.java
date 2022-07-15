package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DBSchoolException;
import model.dao.GradeDaoInterf;
import model.entities.Grade;

public class GradeDao implements GradeDaoInterf {

	private Connection conn;

	public GradeDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Grade obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Grade obj) {

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Grade findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM grade WHERE IdGrade=?");
			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) { // if it is not null (not the first position - zero)
				Grade grade = new Grade();
				grade.setIdGrade(rs.getInt("IdGrade"));
				grade.setGradeName(rs.getString("Grade"));

				return grade;
			} else {
				throw new DBSchoolException("Id not found!");
			}

		} catch (SQLException e) {
			throw new DBSchoolException(e.getMessage());
		}
	}

	@Override
	public List<Grade> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
