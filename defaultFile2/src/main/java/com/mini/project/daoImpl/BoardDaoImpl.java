package com.mini.project.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mini.project.dao.BoardDao;
import com.mini.project.vo.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = sqlSession.selectList("board.getBoardList");
		return list;
	}

	@Override
	public void boardInsert(HashMap<String, Object> map) {
		sqlSession.insert("board.boardInsert", map);
	}

	@Override
	public HashMap<String, Object> getBoardView(int idx) {
		HashMap<String, Object> list = sqlSession.selectOne("board.getBoardView", idx);
		return list;
	}
	
	//게시물 총 갯수
	@Override
	public int boardCount() throws Exception {
		int boardCount = sqlSession.selectOne("board.boardCount");
		return boardCount;
	}

	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		List listPage = sqlSession.selectList("board.listPage", data);	
		
		return listPage;
	}

}
