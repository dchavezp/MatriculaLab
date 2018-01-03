package com.episunsa.controllers;

import java.util.List;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.episunsa.dao.CourseDAO;
import com.episunsa.dao.EvaluationsDAO;
import com.episunsa.dao.RegistrationDAO;
import com.episunsa.dao.StudentDAO;
import com.episunsa.dao.SyllabusDAO;
import com.episunsa.logic.*;

@Controller
public class RegistrationController {

	@Autowired
	CourseDAO course;
	@Autowired
	EvaluationsDAO evaluations;
	@Autowired
	RegistrationDAO registration;
	@Autowired
	StudentDAO student;
	@Autowired
	SyllabusDAO syllabus;

	@RequestMapping(value = "/student/listCourses", method = RequestMethod.GET)
	@ResponseBody
	public String listCourses(Model model, Principal principal) {
		String user = principal.getName();
		Student userStudent = student.findStudentByEmail(user);
		List<Syllabus> slv = syllabus.listAll();
		String response = "";
		int cont = 0;
		for (Syllabus s : slv) {
			if (s.getSemester() % 2 == 0) {// Semestre Par
				if (preCourseApproved(s.getCoursePrerequisite(), userStudent.getStudentID())) {
					response += "<tr>" + "<td>" + (++cont) + "</td>" + "<td>" + s.getCourseID() + "</td>"
							+ "<td><select>" + "<option value='A'>A</option>" + "<option value='B'>A</option>"
							+ "<option value='C'>A</option>" + "<option value='D'>A</option>" + "</select></td>"+"</tr>";
				}
				response += "<b>No tiene cursos para matricularse</b>";
			}
		}
		return response;
	}
	@RequestMapping(value = "/student/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }
	private boolean preCourseApproved(String courseID, int studentID) {
		if (evaluations.isApproved(courseID, studentID))
			return true;
		return false;
	}
}
