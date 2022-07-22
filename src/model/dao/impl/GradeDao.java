package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnectionSchool;
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
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO grade (Grade) values (?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getGradeName());
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdGrade(id);
				}
				DBConnectionSchool.closeResultSet(rs);
			} else {
				throw new DBSchoolException("Unexpected error! No rows affected!");
			}

		} catch (SQLException e) {
			throw new DBSchoolException(e.getMessage());
		} finally {
			DBConnectionSchool.closeStatement(st);
		}

	}

	@Override
	public void update(Grade obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE grade SET Grade=? WHERE IdGrade=?");
			st.setString(1, obj.getGradeName());
			st.setInt(2, obj.getIdGrade());

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DBSchoolException(e.getMessage());
		} finally {
			DBConnectionSchool.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("delete from grade where IdGrade=?");
			st.setInt(1, id);
			int rows = st.executeUpdate();

			if (rows == 0) {
				throw new DBSchoolException("Id not found! No record deleted!");
			} else {
				System.out.println("Delete Completed!");
			}

		} catch (SQLException e) {
			throw new DBSchoolException(e.getMessage());
		} finally {
			DBConnectionSchool.closeStatement(st);
		}
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
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			List<Grade> list = new ArrayList<>();
			st = conn.prepareStatement("Select * from grade order by IdGrade");
			rs = st.executeQuery();

			while (rs.next()) {
				list.add(new Grade(rs.getInt("IdGrade"), rs.getString("Grade")));
			}
			return list; // must to be treated in case off any data!!!!
		} catch (SQLException e) {
			throw new DBSchoolException(e.getMessage());
		} finally {
			DBConnectionSchool.closeResultSet(rs);
			DBConnectionSchool.closeStatement(st);
		}
	}
}
