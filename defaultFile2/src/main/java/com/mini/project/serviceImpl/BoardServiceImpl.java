package com.mini.project.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.project.dao.BoardDao;
import com.mini.project.service.BoardService;
import com.mini.project.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = boardDao.getBoardList();
		return list;
	}

	@Override
	public void boardInsert(HashMap<String, Object> map) {
		boardDao.boardInsert(map);
		
	}

	@Override
	public HashMap<String, Object> getBoardView(int idx) {
		HashMap<String, Object> list = boardDao.getBoardView(idx);
		return list;
	}

	@Override
	public int boardCount() throws Exception {
		int boardCount = boardDao.boardCount();
		return boardCount;
	}

	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		List listPage = boardDao.listPage(displayPost, postNum);
		return listPage;
	}
	

}
