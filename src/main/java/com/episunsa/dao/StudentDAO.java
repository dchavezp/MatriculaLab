package com.episunsa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.episunsa.logic.Student;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO implements InterfaceDAO<Student> {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Student dat) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO student(studentName,studentLastName,studentCUI,username,password,third) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, dat.getStudentName(), dat.getLastName(), dat.getCui(), dat.getUsername(),
				dat.getPassword(), dat.getThird());
	}

	@Override
	public List<Student> listAll() {
		String sql = "SELECT * from student";
		// TODO Auto-generated method stub
		List<Student> listStudents = jdbcTemplate.query(sql, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student aStudent = new Student();
				aStudent.setStudentID(rs.getInt("studentID"));
				aStudent.setStudentName(rs.getString("studentName"));
				aStudent.setLastName(rs.getString("studentLastName"));
				aStudent.setCui(rs.getString("studentCUI"));
				aStudent.setUsername(rs.getString("username"));
				aStudent.setPassword(rs.getString("password"));
				aStudent.setThird(rs.getInt("third"));
				aStudent.setEnable(rs.getInt("enabled"));
				return aStudent;
			}
		});

		return listStudents;
	}

	@Override
	public void update(Student dat) {
		// TODO Auto-generated method stub
		String sql = "UPDATE student SET" + ", studentName= '" + dat.getStudentName() + "'" + ", studentLastName= '"
				+ dat.getLastName() + "'" + ", studentCUI= '" + dat.getCui() + "'" + ", username= '" + dat.getUsername()
				+ "'" + ", password= '" + dat.getPassword() + "'" + ", third= '" + dat.getThird() + "'" + ", enabled= '"
				+ dat.getEnable() + "'" + " where studentID= '" + dat.getStudentID() + "'";
		jdbcTemplate.update(sql);

	}

	public Student findStudentByEmail(String email) {
		String sql = "SELECT * from student WHERE username= '" + email + "'";
		// TODO Auto-generated method stub
		List<Student> listStudents = jdbcTemplate.query(sql, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student aStudent = new Student();
				aStudent.setStudentID(rs.getInt("studentID"));
				aStudent.setStudentName(rs.getString("studentName"));
				aStudent.setLastName(rs.getString("studentLastName"));
				aStudent.setCui(rs.getString("studentCUI"));
				aStudent.setUsername(rs.getString("username"));
				aStudent.setPassword(rs.getString("password"));
				aStudent.setThird(rs.getInt("third"));
				aStudent.setEnable(rs.getInt("enabled"));
				return aStudent;
			}
		});

		return listStudents.get(0);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
