package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.StudenDao;
import com.example.logic.Student;
public class LoginService {
	@Autowired
	StudenDao sd;
	public boolean validateUser(String user, String password) {
		Student ts=sd.findByEmail(user);
		return ts.getCorreoAlumno().equals(user) && password.equals(ts.getContrasenaAlumno())&& ts.getEstadoAlumno().equals("0");
	}
}
