package com.study.spring.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.study.spring.mapper.memberMapper";
	
	@Override
	public String getNow(){
		return sqlSession.selectOne(namespace+".getNow");
	}
	
	@Override
	public void insertMember(MemberVO vo){
		sqlSession.insert(namespace+".insertMember",vo);
		//								이거랑 memberMapper.xml id랑 이름이 똑같아야댐
	}

	@Override
	public MemberVO get(String user_id) {
		return sqlSession.selectOne(namespace+".get",user_id);
	}
	// 다 가져올려면 select 쓰고 
	@Override
	public List<MemberVO> getList() {
		return sqlSession.selectList(namespace+".getList");
	}
	
	// 하나만 가져올경우에 뒤에 vo를 붙여준다
	@Override
	public void updateMember(MemberVO vo){	
		sqlSession.update(namespace+".update",vo);
	}

	@Override
	public void deleteMember(String user_id) {
		sqlSession.delete(namespace+".delete",user_id);
	}
}
