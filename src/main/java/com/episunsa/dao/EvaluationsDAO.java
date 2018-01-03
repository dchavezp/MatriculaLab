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

import com.episunsa.logic.Evaluations;

@Repository
public class EvaluationsDAO implements InterfaceDAO<Evaluations> {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Evaluations dat) throws UnsupportedOperationException {
	}

	@Override
	public List<Evaluations> listAll() {
		String sql = "SELECT * from evaluations";
		// TODO Auto-generated method stub
		List<Evaluations> listEvaluations = jdbcTemplate.query(sql, new RowMapper<Evaluations>() {
			public Evaluations mapRow(ResultSet rs, int rowNum) throws SQLException {
				Evaluations aStudent = new Evaluations.BuilderEvaluations(rs.getString("courseID"),
						rs.getInt("studentID")).setEvaluationN1(rs.getDouble("evaluationN1"))
								.setEvaluationN2(rs.getDouble("evaluationN2"))
								.setEvaluationN3(rs.getDouble("evaluationN3")).build();
				return aStudent;
			}
		});
		return listEvaluations;
	}

	@Override
	public void update(Evaluations dat) throws UnsupportedOperationException {
	}

	public boolean isApproved(String courseID, int studentID) {
		String sql = "SELECT * from evaluations WHERE courseID= '" + courseID + "'" + " AND studentID='" + studentID
				+ "'";
		List<Evaluations> listEvaluations = jdbcTemplate.query(sql, new RowMapper<Evaluations>() {
			public Evaluations mapRow(ResultSet rs, int rowNum) throws SQLException {
				Evaluations aStudent = new Evaluations.BuilderEvaluations(rs.getString("courseID"),
						rs.getInt("studentID")).setEvaluationN1(rs.getDouble("evaluationN1"))
								.setEvaluationN2(rs.getDouble("evaluationN2"))
								.setEvaluationN3(rs.getDouble("evaluationN3")).build();
				return aStudent;
			}
		});
		if (listEvaluations.get(0).getState())
			return listEvaluations.get(0).getState();
		return false;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
