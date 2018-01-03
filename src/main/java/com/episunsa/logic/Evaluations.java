package com.episunsa.logic;

public class Evaluations {
	
	private final String courseID;
	private final int studentID;
	private final double evaluationN1;
	private final double evaluationN2;
	private final double evaluationN3;
	private double prom=0.0;
	private boolean state=StudentState.APPROVED.state();

	public static class BuilderEvaluations implements Builder<Evaluations>{
		private final String courseID;
		private final int studentID;
		private double evaluationN1=0.0;
		private double evaluationN2=0.0;
		private double evaluationN3=0.0;
		public BuilderEvaluations(String course,int codStudendt) {
			this.courseID=course;
			this.studentID=codStudendt;
		}
		public BuilderEvaluations setEvaluationN1(double n1) {
			this.evaluationN1=n1;
			return this;
		}
		public BuilderEvaluations setEvaluationN2(double n2) {
			this.evaluationN2=n2;
			return this;
		}
		public BuilderEvaluations setEvaluationN3(double n3) {
			this.evaluationN3=n3;
			return this;
		}
		@Override
		public Evaluations build() {
			// TODO Auto-generated method stub
			return new Evaluations(this);
		}
		
	}
	private Evaluations(BuilderEvaluations build){
		this.courseID=build.courseID;
		this.studentID=build.studentID;
		this.evaluationN1=build.evaluationN1;
		this.evaluationN2=build.evaluationN2;
		this.evaluationN3=build.evaluationN3;
		this.prom=Math.round(build.evaluationN1+build.evaluationN2+build.evaluationN3);
		if(this.prom<10)
			this.state=StudentState.DESAPPROVED.state();
		this.state=StudentState.APPROVED.state();
	}
	public boolean getState() {
		return state;
	}
	public String getCourseID() {
		return courseID;
	}
	public int getStudentID() {
		return studentID;
	}
	public double getEvaluationN1() {
		return evaluationN1;
	}
	public double getEvaluationN2() {
		return evaluationN2;
	}
	public double getEvaluationN3() {
		return evaluationN3;
	}
	public double getProm() {
		return prom;
	}
	public enum StudentState {
		APPROVED(true), DESAPPROVED(false);
		private boolean state;

		StudentState(boolean state) {
			this.state=state;
		}
		public boolean state() {
			return state;
		}
	}
	
}
