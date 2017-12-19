package com.example.dao;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.logic.Student;
@Repository
public class StudenDao implements InterfaceDao<Student>{
	private  JdbcTemplate jdbcTemplate; 
	@Override
	public List<Student> listAll() {
		String sql = "SELECT idAlumno, nombreAlumno, estadoAlumno, cuiAlumno, apellidoAlumno, correoAlumno, contrasenaAlumno FROM alumno";

		List<Student> listContact = jdbcTemplate.query(sql, new RowMapper<Student>() {


			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub

				Student aContact = new Student();
				aContact.setIdAlumno(rs.getInt("idAlumno"));
				aContact.setNombreAlumno(rs.getString("nombreAlumno"));
				aContact.setApellidoAlumnno(rs.getString("estadoAlumno"));
				aContact.setCuiAlumno(rs.getString("cuiAlumno"));
				aContact.setCorreoAlumno(rs.getString("correoAlumno"));
				aContact.setContrasenaAlumno(rs.getString("contrasenaAlumno"));
				aContact.setEstadoAlumno(rs.getString("estadoAlumno"));
				return aContact;
			}

		});		 
		return listContact;
	}

	@Override
	public void add(Student e) {
		String sql = "INSERT INTO alumno(nombreAlumno, cuiAlumno, apellidoAlumno, correoAlumno, contrasenaAlumno)values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				e.getNombreAlumno(),
				e.getCuiAlumno(),
				e.getApellidoAlumnno(),
				e.getCorreoAlumno(),
				e.getContrasenaAlumno());
				
	}

	@Override
	public void update(Student e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeState(int id, char state) {
		// TODO Auto-generated method stub
		
	}
	public Student findByEmail(String e) {
		String sql = "SELECT * FROM alumno WHERE correoAlumno = " + e;
		List<Student> listContact = jdbcTemplate.query(sql, new RowMapper<Student>() {


			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub

				Student aContact = new Student();
				aContact.setIdAlumno(rs.getInt("idAlumno"));
				aContact.setNombreAlumno(rs.getString("nombreAlumno"));
				aContact.setApellidoAlumnno(rs.getString("estadoAlumno"));
				aContact.setCuiAlumno(rs.getString("cuiAlumno"));
				aContact.setCorreoAlumno(rs.getString("correoAlumno"));
				aContact.setContrasenaAlumno(rs.getString("contrasenaAlumno"));
				aContact.setEstadoAlumno(rs.getString("estadoAlumno"));
				return aContact;
			}

		});		 
		return listContact.get(0);
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
