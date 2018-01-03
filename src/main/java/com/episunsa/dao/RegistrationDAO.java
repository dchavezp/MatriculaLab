package com.episunsa.dao;

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

import com.episunsa.logic.Registration;

@Repository
public class RegistrationDAO implements InterfaceDAO<Registration> {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Registration dat) {
		String sql = "INSERT INTO registration(studentID,courseID,groupRegistration) values (?, ?, ?)";
		jdbcTemplate.update(sql, dat.getStudentID(), dat.getCourseID(), dat.getGroupRegistration());
	}

	@Override
	public List<Registration> listAll() {
		String sql = "SELECT * from registration";
		// TODO Auto-generated method stub
		List<Registration> list = jdbcTemplate.query(sql, new RowMapper<Registration>() {
			public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
				Registration aRegistry = new Registration.BuilderRegistration(rs.getInt("studentID"),
						rs.getString("courseID")).setGroup(rs.getString("groupRegistration")).build();
				return aRegistry;
			}
		});
		return list;
	}

	@Override
	public void update(Registration dat) {
		String sql = "UPDATE student SET courseID= '" + dat.getCourseID() + "'" + ", groupRegistration= '"
				+ dat.getGroupRegistration() + "'" + " WHERE studentID= '" + dat.getStudentID() + "'";
		jdbcTemplate.update(sql);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Registration> listRegUser(int studentID){
		String sql = "SELECT * from registration WHERE studentID='"+studentID+"'";
		// TODO Auto-generated method stub
		List<Registration> list = jdbcTemplate.query(sql, new RowMapper<Registration>() {
			public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
				Registration aRegistry = new Registration.BuilderRegistration(rs.getInt("studentID"),
						rs.getString("courseID")).setGroup(rs.getString("groupRegistration")).build();
				return aRegistry;
			}
		});
		return list;
	}
}
