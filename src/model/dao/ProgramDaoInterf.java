package model.dao;

import java.util.List;

import model.entities.Program;

public interface ProgramDaoInterf {
	void insert(Program obj);

	void update(Program obj);

	void deleteById(Integer id);

	Program findById(Integer id);
	
	List<Program> findAll();
}