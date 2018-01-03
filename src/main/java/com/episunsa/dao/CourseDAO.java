package com.episunsa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.episunsa.logic.Course;

@Repository
public class CourseDAO implements InterfaceDAO<Course> {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Course dat) throws UnsupportedOperationException {
	}

	@Override
	public List<Course> listAll() {
		String sql = "SELECT * from course";
		// TODO Auto-generated method stub
		List<Course> listCourses = jdbcTemplate.query(sql, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course aCourse = new Course();
				aCourse.setCourseID(rs.getString("courseID"));
				aCourse.setCourseName(rs.getString("courseName"));
				aCourse.setEnable(rs.getBoolean("enabled"));
				return aCourse;
			}
		});
		return listCourses;
	}

	@Override
	public void update(Course dat) throws UnsupportedOperationException {
	}

	public Course findCourseById(String id) {
		String sql = "SELECT * from course WHERE courseID= '" + id + "'";
		// TODO Auto-generated method stub
		List<Course> listStudents = jdbcTemplate.query(sql, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course aCourse = new Course();
				aCourse.setCourseID(rs.getString("courseID"));
				aCourse.setCourseName(rs.getString("courseName"));
				aCourse.setEnable(rs.getBoolean("enabled"));
				return aCourse;
			}
		});
		return listStudents.get(0);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
