package com.fftl.springboard;

import java.util.List;
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
	
	public int updateView(Map<String, Object> map){
		return this.sqlsessionTemplate.update("board.update_view", map);
	}
	
	public int updateBoard(Map<String, Object> map){
		return this.sqlsessionTemplate.update("board.update_board", map);
	}
	
	public int deleteBoard(Map<String, Object> map){
		return this.sqlsessionTemplate.delete("board.delete", map);
	}
	
	public List<Map<String, Object>> selectAll(Map<String, Object> map){
		return this.sqlsessionTemplate.selectList("board.select_all", map);
	}
	
}
