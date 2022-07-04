package com.fftl.springboard;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public String create(Map<String, Object> map) {
		int rowCount = this.boardDao.insert(map);
		if(rowCount == 1) {
			return map.get("board_id").toString();
		}
		return null;
		
	}
	
	@Override
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.boardDao.selectDetail(map);
	}
	
	@Override
	public boolean updateView(Map<String, Object> map){
		return 1 == this.boardDao.updateView(map);
	}
	
	@Override
	public boolean updateBoard(Map<String, Object> map){
		return 1 == this.boardDao.updateBoard(map);
	}
	
	@Override
	public boolean deleteBoard(Map<String, Object> map){
		return 1 == this.boardDao.deleteBoard(map);
	}
	
	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return this.boardDao.selectAll(map);
	}
	
	
}
