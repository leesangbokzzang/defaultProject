package com.mini.project.service;

import java.util.HashMap;
import java.util.List;

import com.mini.project.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getBoardList();
	
	//게시판글쓰기기능
	public void boardInsert(HashMap<String, Object> map);
	
	//게시글읽기
	public HashMap<String, Object> getBoardView(int idx);
	
	//게시물 총 갯수
	public int boardCount() throws Exception;
	
	//게시물 목록 + 페이징
	public List listPage(int displayPost, int postNum) throws Exception;
}
