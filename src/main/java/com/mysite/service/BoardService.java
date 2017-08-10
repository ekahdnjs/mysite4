package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mysite.repository.BoardDao;
import com.mysite.vo.BoardVo;


@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
public List<BoardVo> getlist() {
		
		return boardDao.getlist();
	}

	public BoardVo read(int no) {
		return boardDao.read(no);
		
	}

	public int write(BoardVo vo) {
		return boardDao.write(vo);
	}
	

	public int Hit(BoardVo vo) {
		return boardDao.plusHit(vo);
		
	}
	public int modify(BoardVo vo) {
		return boardDao.modify(vo);
		
	}

	public int delete(BoardVo vo) {
		return boardDao.delete(vo);
	}




	
	
}
