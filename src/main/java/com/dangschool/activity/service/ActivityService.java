package com.dangschool.activity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.dangschool.activity.command.ActivityVO;
import com.dangschool.activity.command.ImgVO;
import com.dangschool.util.Criteria;

public interface ActivityService {
	public int insert(ActivityVO vo); //�� �ۼ�
	public List<ActivityVO> list(Criteria cri);
	public ArrayList<ImgVO> imgList();
	public int getTotal(Criteria cri);
	public ActivityVO content(int num);
	public void hit(int num);
	public void insertFile(Map<String, Object> map, MultipartFile[] file,HttpSession session) throws Exception;
	public ArrayList<ImgVO> uploadfile(int num);
	public void delete(int num);
}
