package com.study.spring.persistence;

import java.util.List;
import java.util.Iterator;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.spring.domain.MemberVO;
import com.study.spring.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {
	
	@Inject
	private MemberDAO dao;
	@Test
	public void test() {System.out.println("Test DAO = " + dao);}
	@Test
	public void getNowTest(){System.out.println("Test DAO now = " + dao.getNow());};
	
	@Test
	public void insertTest() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUser_id("id" + System.currentTimeMillis());
		vo.setUser_name("중원");
		vo.setPw("gogo");
		vo.setEmail("gto@nananan.com");
		
		dao.insertMember(vo);
	}
		
	@Test
	public void getTest() throws Exception{
		MemberVO vo = dao.get("yh");
		System.out.println("이름: " +vo.getUser_name());
	}
	
	@Test
	public void getListTest() throws Exception{
		List<MemberVO> list = dao.getList();
		Iterator<MemberVO> it = list.iterator();
		while (it.hasNext()) {
			MemberVO vo = it.next();
			System.out.println("이름: " + vo.getUser_name());
		}
	}
	
	@Test
	public void update() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setPw("g");
		vo.setEmail("gg@gg");
		vo.setUser_name("gg");
		vo.setUser_id("yh");
		
		dao.updateMember(vo);
	}
	
	@Test
	public void delete() throws Exception{
		
		dao.deleteMember("ddf");
	}
}
