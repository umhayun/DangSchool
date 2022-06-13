package com.dangschool.activity.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dangschool.activity.command.ActivityVO;
import com.dangschool.activity.command.ImgVO;
import com.dangschool.util.Criteria;

public interface ActivityMapper {
	public int insert(ActivityVO vo);
	public List<ActivityVO> list(Criteria cri);
	public int getTotal(Criteria cri);
	public ActivityVO content(int num);
	public void updatehit(int num);
	public void insertFile(Map<String, Object> map);
	public int maxNum();
	public int minNum();
	public ArrayList<ImgVO> getImg(int num);
	public ArrayList<ImgVO> getThumbnail();
	public void delete(int num);
}
