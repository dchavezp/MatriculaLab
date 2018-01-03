package com.episunsa.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


import java.util.List;

import com.episunsa.logic.*;

public class LogicTest {
	Evaluations ev = new Evaluations.BuilderEvaluations("12345", 2).setEvaluationN1(5).setEvaluationN2(8)
			.setEvaluationN3(3).build();
	List<Evaluations> lev;
	@Test
	public void stateEvTest() {
		assertEquals(true, ev.getCourseState());
	} 	
}
