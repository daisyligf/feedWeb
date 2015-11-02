package com.mofang.feedweb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mofang.feedweb.global.GlobalObject;

@Controller
public class uploadFileTool extends HttpServlet {
    
    @RequestMapping("/fileUpload")
    public void fileUpload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
      long startTime=System.currentTimeMillis();   //获取开始时间
      response.setContentType("text/html; charset=UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      if(!file.isEmpty()){
    	  String to = request.getParameter("to");
    	  int index = to.lastIndexOf("/");
    	  String filePath = to.substring(0, index+1);
    	  
        try {
        	  File newFile = new File(filePath);
			  if(!newFile.exists()){
					newFile.mkdir();
			  }
				
	          //定义输出流 将文件保存在D盘    file.getOriginalFilename()为获得文件的名字 
	          //FileOutputStream os = new FileOutputStream(filePath + file.getOriginalFilename());
	        	FileOutputStream os = new FileOutputStream(filePath + file.getOriginalFilename());
	          InputStream in = file.getInputStream();
	          int b = 0;
	          while((b=in.read())!=-1){ //读取文件 
	            os.write(b);
	          }
	          os.flush(); //关闭流 
	          in.close();
	          os.close();
	          
	          long endTime=System.currentTimeMillis(); //获取结束时间
	          GlobalObject.INFO_LOG.info(file.getOriginalFilename() + "上传文件共使用时间："+(endTime-startTime));
	          PrintWriter out = response.getWriter();
	          out.print(0);
	          out.flush();
	          out.close();
          
        } catch (FileNotFoundException e) {
        	GlobalObject.ERROR_LOG.error(
        			"at uploadFileTool.fileUpload throw an error.", e);
        	PrintWriter out = response.getWriter();
        	out.print(1);
        	out.flush();
        	out.close();
        } catch (IOException e) {
        	GlobalObject.ERROR_LOG.error(
      				"at uploadFileTool.fileUpload throw an error.", e);
        	PrintWriter out = response.getWriter();
        	out.print(1);
        	out.flush();
         	out.close();
        }
      }

    }
}
