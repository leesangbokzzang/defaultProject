package com.mini.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mini.project.service.BoardService;
import com.mini.project.vo.BoardVO;

@Controller
public class JoinController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView joinFm(@RequestParam(value="num", defaultValue="1") int num, String viewNum)  throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println("controller");
		
		if(viewNum == null) {
			viewNum = "5";
		}
		System.out.println(viewNum);
		
		//게시물 총 갯수
		int boardCount = boardService.boardCount();
		
		//한페이지에 출력할 게시물 갯수
		int postNum = Integer.parseInt(viewNum);
		
		//하단 페이징 번호
		int pageNum = (int)Math.ceil((double) boardCount/postNum);
		
		int displayPost = (num - 1) * postNum;
		
		//한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;
		
		//표시되는 페이지 번호중 마지막 번호 
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		
		//표시되는 페이지 번호 중 첫번쨰 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		//마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)boardCount / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= boardCount ? false : true;
		
		List<BoardVO> list =  boardService.listPage(displayPost, postNum);
		mav.addObject("list", list);
		mav.addObject("pageNum", pageNum);
		
		//시작 및 끝 번호
		mav.addObject("startPageNum", startPageNum);
		mav.addObject("endPageNum", endPageNum);
		
		//이전 및 다음
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		
		//현재페이지 구분하기
		mav.addObject("select", num);
		
		//게시물 고정값
		mav.addObject("postNum", postNum);
		
		mav.setViewName("join/joinFm");
		return mav;
	}
}
