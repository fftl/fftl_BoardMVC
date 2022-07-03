package com.fftl.springboard;

import java.text.DateFormat;
import java.util.Date;
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
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("data", detailMap);
		String boardId = map.get("boardId").toString();
		mav.addObject("bookId", boardId);
		mav.setViewName("/board/detail");
		
		return mav;
	}
		
	
}
