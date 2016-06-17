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
		//								�̰Ŷ� memberMapper.xml id�� �̸��� �Ȱ��ƾߴ�
	}

	@Override
	public MemberVO get(String user_id) {
		return sqlSession.selectOne(namespace+".get",user_id);
	}
	// �� �����÷��� select ���� 
	@Override
	public List<MemberVO> getList() {
		return sqlSession.selectList(namespace+".getList");
	}
	
	// �ϳ��� �����ð�쿡 �ڿ� vo�� �ٿ��ش�
	@Override
	public void updateMember(MemberVO vo){	
		sqlSession.update(namespace+".update",vo);
	}

	@Override
	public void deleteMember(String user_id) {
		sqlSession.delete(namespace+".delete",user_id);
	}
}
