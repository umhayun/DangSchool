package com.dangschool.activity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dangschool.activity.command.ActivityVO;
import com.dangschool.activity.command.CommandMap;
import com.dangschool.activity.command.FileUtils;
import com.dangschool.activity.command.ImgVO;
import com.dangschool.activity.mapper.ActivityMapper;
import com.dangschool.util.Criteria;
@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	ActivityMapper mapper;
	@Autowired
	FileUtils fileUtils;
	@Resource(name="uploadPath")
    String uploadPath;
	@Override
	public int insert(ActivityVO vo) {
		// TODO Auto-generated method stub
		int result=mapper.insert(vo);
		
		return result;
		
	}
	@Override
	public ArrayList<ImgVO> imgList() {
		ArrayList<ImgVO> list=mapper.getThumbnail();
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public List<ActivityVO> list(Criteria cri) {
		List<ActivityVO> list=mapper.list(cri);
		//List<ImgVO> list2=mapper.list(cri);
		return list;
	}
	 @Override
	public int getTotal(Criteria cri) {
		int total=mapper.getTotal(cri);
		return total;
	}
	 @Override
	public ActivityVO content(int num) {
		int last=mapper.maxNum();
		int first=mapper.minNum();
		ActivityVO vo=mapper.content(num);		
		
		
		vo.setLast(last);
		vo.setFirst(first);
		
		return vo;
	}
	 
	 @Override
	public void hit(int num) {
		mapper.updatehit(num);
		
	}
	 @Override
	public void insertFile(Map<String, Object> map, MultipartFile[] file,HttpSession session)
			throws Exception {
		 
		 List<Map<String, Object>> fileList = fileUtils.parseFileInfo(map,file,session);
		    for(int i=0; i<fileList.size(); i++) {
		        mapper.insertFile(fileList.get(i));
		    }
	}
	 
	 @Override
	public ArrayList<ImgVO> uploadfile(int num) {
		
		ArrayList<ImgVO> img=mapper.getImg(num);
		// TODO Auto-generated method stub
		
		return img;
	}
	 @Override
	public void delete(int num) {
		mapper.delete(num);
		
		
	}

}
