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

import com.episunsa.logic.Syllabus;

@Repository
public class SyllabusDAO implements InterfaceDAO<Syllabus> {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Syllabus dat) throws UnsupportedOperationException {
	}

	@Override
	public List<Syllabus> listAll() {
		String sql = "SELECT * from syllabus";
		// TODO Auto-generated method stub
		List<Syllabus> list = jdbcTemplate.query(sql, new RowMapper<Syllabus>() {
			public Syllabus mapRow(ResultSet rs, int rowNum) throws SQLException {
				Syllabus aData = new Syllabus();
				aData.setId(rs.getInt("ID"));
				aData.setCourseID(rs.getString("courseID"));
				aData.setCoursePrerequisite(rs.getString("coursePrerequisite"));
				aData.setSemester(rs.getInt("semester"));
				return aData;
			}
		});
		return list;
	}

	@Override
	public void update(Syllabus dat) throws UnsupportedOperationException {
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
