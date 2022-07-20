package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DBConnectionSchool;
import db.DBSchoolException;
import model.dao.ProgramDaoInterf;
import model.entities.Program;

public class ProgramDao implements ProgramDaoInterf {

	Connection conn = null;

	public ProgramDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Program obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Program obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE program SET WeekDays=? WHERE IdProg=?");
			st.setString(1, obj.getWeekDays());
			st.setInt(2, obj.getIdProgram());

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DBSchoolException(e.getMessage());
		} finally {
			DBConnectionSchool.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Program findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM program WHERE IdProg=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Program newProg = new Program();
				newProg.setIdProgram(rs.getInt("IdProg"));
				newProg.setProgramName(rs.getString("Program"));
				newProg.setWeekDays(rs.getString("WeekDays"));

				return newProg;
			} else {
				throw new DBSchoolException("Id not found!");
			}

		} catch (SQLException e) {
			throw new DBSchoolException(e.getMessage());
		} finally {
			DBConnectionSchool.closeResultSet(rs);
			DBConnectionSchool.closeStatement(st);
		}
	}

	@Override
	public List<Program> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
