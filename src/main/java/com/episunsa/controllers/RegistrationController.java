package com.episunsa.controllers;

import java.util.List;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
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
	private int day = 2;

	@RequestMapping(value = "/student/listCourses", method = RequestMethod.GET)
	@ResponseBody
	public String listCourses(Model model, Principal principal) {
		String user = principal.getName();
		Student userStudent = student.findStudentByEmail(user);
		if (day == 1 && userStudent.getThird() == 1) {
			return responsePgRegistry(principal,model);
		}
		else if(day == 2 && userStudent.getThird() == 2)
		{
			return responsePgRegistry(principal,model);
		}
		else if(day == 3 && userStudent.getThird() == 3)
		{
			return responsePgRegistry(principal,model);
		}
		else
			return "No le corresponde matricularse este día <a href='../welcome'> Regresar</a>";
	}

	@RequestMapping(value = "/student/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		return "registration";
	}

	private String nameCourse(String cod) {
		return course.findCourseById(cod).getCourseName();
	}
	private String responsePgRegistry(Principal principal,Model model) {
		String user = principal.getName();
		Student userStudent = student.findStudentByEmail(user);
		List<Evaluations> eval = evaluations.listCourses(userStudent.getStudentID());
		String response = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><title>Matricula</title></head>"
				+ "<body><h2>Lista de Cursos</h2><h3>Usuario :"
				+ principal.getName() + "</h3>"
				+ "<form action=\"/MatriculaLab/student/saveRegistry\" method=\"POST\"><table><tr><th>Nro</th><th>Curso</th><th>Grupo</th></tr>";
		int cont = 0;
		for (Evaluations s : eval) {
			if (s.getCourseState()) {
				response += "<tr>" + "<td>" + (++cont) + "</td>" + "<td>"
						+ nameCourse(syllabus.getcourseToTake(s.getCourseID())) + "</td>" + "<td><select name='group'>"
						+ "<option value='A'>A</option>" + "<option value='B'>B</option>"
						+ "<option value='C'>C</option>" + "<option value='D'>D</option>" + "</select></td>"
						+ "</tr>"
						+ "<input type=\"hidden\" name='courseid' value='"+syllabus.getcourseToTake(s.getCourseID())+"'>";
			} else
				response += "Usted no tiene cursos para matricularse <a href='../welcome'> Regresar</a>";

		}
		
		response += "</table>"
				+ "<input type=\"submit\" value=\"Matricularse\"></form>"
				+ "<a href='../welcome'> Regresar</a></body></html>";
		return response;
	}
	@RequestMapping(value = "/student/saveRegistry", method = RequestMethod.POST)
	public String saveReg(@RequestBody MultiValueMap<String, String> params,Principal principal) {
		String group=params.getFirst("group");
		String user=principal.getName();
		String course=params.getFirst("courseid");
		Student userStudent = student.findStudentByEmail(user);
		Registration rg=new Registration.BuilderRegistration(userStudent.getStudentID(), course).setGroup(group).build();
		registration.add(rg);
		return "success";
		
	}
	@RequestMapping(value = "/student/listCoursesReg", method = RequestMethod.GET)
	@ResponseBody
	public String listCoursesReg(Model model, Principal principal) {
		String user=principal.getName();
		Student userStudent = student.findStudentByEmail(user);
		List<Registration> list=registration.listRegUser(userStudent.getStudentID());
		String response="<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><title>Constancia Matricula</title></head>"
				+ "<body><h2>Constancia de matricula</h2><h3>Usuario :"
				+ userStudent.getStudentName()+ "</h3>"
				+ "<table><tr><th>Nro</th><th>Curso</th><th>Grupo</th>";
		int cont = 0;
		for(Registration r:list) {
			response += "<tr>" + "<td>" + (++cont) + "</td>" + "<td>"+ nameCourse(r.getCourseID()) + "</td>"+"<td>"+ r.getGroupRegistration() + "</td>";
		}
		response += "</table><a href='../welcome'> Regresar</a></body></html>";
		return response;
		
	}
}
