package com.fftl.springboard;

import java.util.List;
import java.util.Map;

public interface BoardService {

	String create(Map<String, Object> map);

	Map<String, Object> selectDetail(Map<String, Object> map);

	List<Map<String, Object>> selectList(Map<String, Object> map);

	boolean updateView(Map<String, Object> map);

	boolean updateBoard(Map<String, Object> map);

	boolean deleteBoard(Map<String, Object> map);

}
