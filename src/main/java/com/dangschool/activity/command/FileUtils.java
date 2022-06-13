package com.dangschool.activity.command;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Component("FileUtils")
public class FileUtils {
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource(name="uploadPath")
    String uploadPath;
 
    public List<Map<String, Object>> parseFileInfo(Map<String, Object> map, MultipartFile[] file, HttpSession session) throws Exception {
    	
        //int boardIDX = vo.getNum();
        String creaID = (String)session.getAttribute("user_id");

        List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();

        File target = new File(uploadPath);
        
        if(!target.exists()) target.mkdirs();
        
        for(int i=0; i<file.length; i++) {
 
            String orgFileName = file[i].getOriginalFilename();
            String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
            String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
            Long saveFileSize = file[i].getSize();
            
            log.debug("================== file start ==================");
            log.debug("원래 파일이름: "+orgFileName);
            log.debug("저장 파일이름: "+saveFileName);
            log.debug("파일 크기: "+saveFileSize);
            log.debug("content type: "+file[i].getContentType());
            log.debug("================== file   END ==================");
 
            target = new File(uploadPath, saveFileName);
            file[i].transferTo(target);
            
            Map<String, Object> fileInfo = new HashMap<String, Object>();
 
            //fileInfo.put("BOARD_IDX", num);
            fileInfo.put("ORG_FILE_NAME", orgFileName);
            fileInfo.put("SAVE_FILE_NAME", saveFileName);
            fileInfo.put("FILE_SIZE", saveFileSize);
            fileInfo.put("CREA_ID", creaID);
            fileList.add(fileInfo);
            
        }
        return fileList;
    }
}

