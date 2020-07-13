package com.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDaoImpl implements MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		System.out.println(id);
		String sql = "select * from usermember where id = ?";
		
		try {
			return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class),id);
		}catch(EmptyResultDataAccessException e) {
			// EmptyResultDataAccessException 예외 발생시 null 리턴
			return null;
		}
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException {
		String sql = " select * from userMember where id=? and pwd=? ";
		boolean result = false;
		Object[] params = {id,pwd};
		
		if(this.jdbcTemplate.queryForList(sql, params).size() > 0) result = true;
		
		return result;
		}

	@Override
	public boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException {
		String sql = "insert into userMember values(?, ?, ?, ?, ?)";
		boolean result = false;
		Object[] params = {id, name, pwd, email, age};
		
		if(this.jdbcTemplate.update(sql, params)>0) {
			result = true;
		}
		return result;
	}


}
