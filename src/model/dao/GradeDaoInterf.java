package model.dao;

import java.util.List;

import model.entities.Grade;

public interface GradeDaoInterf {

	void insert(Grade obj);

	void update(Grade obj);

	void deleteById(Integer id);

	Grade findById(Integer id);
	
	List<Grade> findAll();

}
