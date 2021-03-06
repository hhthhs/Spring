package com.model;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {

	//회원상세 조회
	MemberVO selectMemberById(String id) throws SQLException;

	//회원 유무를 판단하는 조회 메서드
	boolean memberCheck(String id, String pwd) throws SQLException;
	
	boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException;
	
	
}
