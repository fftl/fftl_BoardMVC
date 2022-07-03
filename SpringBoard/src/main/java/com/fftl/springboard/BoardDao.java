package com.fftl.springboard;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.sqlsessionTemplate.insert("board.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.sqlsessionTemplate.selectOne("board.select_detail", map);
	}
	
}
