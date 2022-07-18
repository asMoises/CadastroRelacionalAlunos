package model.entities;

import java.util.Objects;

public class Program {
	
	private Integer idProgram;
	private String 	programName;
	private String weekDays;
	
	public Program() {
		
	}
	
	public Program(Integer idProgram, String programName, String weekDays) {
		this.idProgram = idProgram;
		this.programName = programName;
		this.weekDays = weekDays;
	}

	public Integer getIdProgram() {
		return idProgram;
	}

	public void setIdProgram(Integer idProgram) {
		this.idProgram = idProgram;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}

	@Override
	public String toString() {
		return "Program [id= " + idProgram + ", Program Name= " + programName + ", Days of week= " + weekDays + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProgram);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Program other = (Program) obj;
		return Objects.equals(idProgram, other.idProgram);
	}
}
