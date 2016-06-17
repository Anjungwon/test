package com.study.springrest.persistence;

import java.util.List;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;

public interface RestDAO {
	
	public RestVO get(int rest_no);
	public List<RestVO> getList();
	public List<RestVO> getListPage(int board_no,Criteria cri);
	public void insert(RestVO vo);
	public void update(RestVO vo);
	public void delete(int rest_no);
	public void increaseReply(int board_no);

}
