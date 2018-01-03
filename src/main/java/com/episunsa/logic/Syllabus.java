package com.episunsa.logic;

public class Syllabus {
	private int id;
	private String courseID;
	private String coursePrerequisite;
	private int semester;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCoursePrerequisite() {
		return coursePrerequisite;
	}
	public void setCoursePrerequisite(String coursePrerequisite) {
		this.coursePrerequisite = coursePrerequisite;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
}
