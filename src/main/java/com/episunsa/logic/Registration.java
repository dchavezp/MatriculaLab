package com.episunsa.logic;

public class Registration {
	private final int studentID;
	private final String courseID;
	private final String groupRegistration;
	public static class BuilderRegistration implements Builder<Registration>{
		private final int studentID;
		private final String courseID;
		private String groupRegistration="";
		public BuilderRegistration(int studentID,String courseID) {
			this.studentID=studentID;
			this.courseID=courseID;
		}
		public BuilderRegistration setGroup(String groupRegistration) {
			this.groupRegistration=groupRegistration;
			return this;
		}
		@Override
		public Registration build() {
			// TODO Auto-generated method stub
			return new Registration(this);
		}	
	}
	private Registration(BuilderRegistration build) {
		this.courseID=build.courseID;
		this.studentID=build.studentID;
		this.groupRegistration=build.groupRegistration;
	}
	public int getStudentID() {
		return studentID;
	}
	public String getCourseID() {
		return courseID;
	}
	public String getGroupRegistration() {
		return groupRegistration;
	}
}
