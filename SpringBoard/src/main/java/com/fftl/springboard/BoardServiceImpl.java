package com.fftl.springboard;

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
	
	
}
