package com.fftl.springboard;

import java.util.Map;

public interface BoardService {

	String create(Map<String, Object> map);

	Map<String, Object> selectDetail(Map<String, Object> map);

}
