package cn.com.chenxin.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.chenxin.response.Response;
import cn.com.chenxin.utils.RandomUtil;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping(value = "common")
public class CommonController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(CommonController.class);

    /**    
     * 文件上传接口
     * @param file  文件
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="uploadFile",method=RequestMethod.POST)
    public @ResponseBody Response uploadFile(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request) {
        logger.info("文件上传开始.......");
        
        
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = RandomUtil.getRandomUpperAndNumStr(10)+file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        JSONObject obj = new JSONObject();
        obj.put("fileUrl", request.getContextPath()+"/upload/"+fileName);
        return Response.ok(obj);

    }

}
