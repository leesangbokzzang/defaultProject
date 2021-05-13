package com.mini.project.dao;

import java.util.HashMap;
import java.util.List;

import com.mini.project.vo.BoardVO;

public interface BoardDao {

	public List<BoardVO> getBoardList();
	
	//글쓰기 기능
	public void boardInsert(HashMap<String, Object> map);
	
	//게시글 읽기
	public HashMap<String, Object> getBoardView(int idx);
	
	//총 게시물 갯수
	public int boardCount() throws Exception;
	
	//게시물 목록 + 페이징 
	public List listPage(int displayPost, int postNum) throws Exception; 
	
}
