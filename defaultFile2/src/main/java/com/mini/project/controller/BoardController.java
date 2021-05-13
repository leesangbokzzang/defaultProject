package com.mini.project.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mini.project.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardInsertFm", method=RequestMethod.GET)
	public String boardInsertFm() {
		return "board/boardInsert";
	}
	
	@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	public ModelAndView boardInsert(@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boardService.boardInsert(map);
		 mav.setViewName("redirect:/board");
		return mav;
	}
	
	@RequestMapping(value="/boardRead", method=RequestMethod.GET)
	public ModelAndView boardInsert(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		HashMap<String, Object> getBoardView = boardService.getBoardView(idx);
		
		System.out.println(getBoardView);
		
		mav.addObject("listView", getBoardView);
		mav.setViewName("board/boardRead");
		return mav;
	}
	
	
	
}
