package com.mysite.repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestBookVo> getList() {
		return sqlSession.selectList("guestbook.getList");
	}
	
	public int insert(GuestBookVo vo) {
		return sqlSession.insert("guestbook.insert", vo);
	}
	
	public int delete(GuestBookVo vo) {
		return sqlSession.insert("guestbook.delete", vo);
	}
}

	

