package com.fftl.springboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sun.launcher.resources.launcher;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam Map<String, Object> map) {
		return new ModelAndView("board/create");

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createBoardAndView(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		String boardId = this.boardService.create(map);
		if(boardId == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?boardId=" + boardId);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.boardService.selectDetail(map);
		this.boardService.updateView(map); //조회수 증가
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("data", detailMap);
		String boardId = map.get("boardId").toString();
		mav.addObject("bookId", boardId);
		mav.setViewName("/board/detail");
		
		return mav;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView selectList(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> detailMap = this.boardService.selectList(map);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("data", detailMap);
		
		mav.setViewName("/board/list");
		
		return mav;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.boardService.selectDetail(map);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/board/update");
		
		return mav;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView updateBoard(@RequestParam Map<String, Object> map) {
		boolean success = this.boardService.updateBoard(map);
		ModelAndView mav= new ModelAndView();
		
		if(success) {
			String boardId = map.get("boardId").toString();
			mav.setViewName("redirect:/detail?boardId=" + boardId);
			
		} else {
			mav = this.update(map);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView deleteBoard(@RequestParam Map<String, Object> map) {
		boolean success = this.boardService.deleteBoard(map);
		ModelAndView mav= new ModelAndView();
		
		if(success) {
			mav.setViewName("redirect:/list");
		} else {
			String boardId = map.get("boardId").toString();
			mav.setViewName("redirect:/detail?boardId="+boardId);
		}
		
		return mav;
	}
		
	
}
