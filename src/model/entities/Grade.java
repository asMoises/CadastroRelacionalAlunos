package model.entities;

import java.util.Objects;

public class Grade {

	private Integer idGrade;
	private String gradeName;

	public Grade() {

	}

	public Grade(Integer idGrade, String gradeName) {
		this.idGrade = idGrade;
		this.gradeName = gradeName;
	}

	public Integer getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(Integer idGrade) {
		this.idGrade = idGrade;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "Grade [id= " + idGrade + ", grade= " + gradeName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idGrade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		return Objects.equals(idGrade, other.idGrade);
	}
}
