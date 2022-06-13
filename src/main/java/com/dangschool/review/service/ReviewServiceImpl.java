package com.dangschool.review.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangschool.review.command.ReviewVO;
import com.dangschool.review.mapper.ReviewMapper;
import com.dangschool.util.Criteria;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper mapper;

	@Override
	public ArrayList<ReviewVO> getList(Criteria cri) {
		
		ArrayList<ReviewVO> list = mapper.pagingList(cri);
		return list;
	}

	@Override
	public int getTotal() {
		int total = mapper.getTotal();
		return total;
	}

	@Override
	public void register(ReviewVO vo) {
		mapper.insertReview(vo);
		
	}

	@Override
	public ReviewVO getContent(int num) {
		ReviewVO vo = mapper.getContent(num);
		return vo;
	}


	@Override
	public void delete(int num) {
		mapper.deleteReview(num);
		
	}
	
	
}
