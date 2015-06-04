package com.mofang.feedweb.util;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.impl.client.CloseableHttpClient;
import org.json.JSONObject;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.net.http.HttpClientProvider;

public class Tools {
	
	public static String getHttpInfo(String feedUrl, HttpClientProvider provider,String interfaceURL) 
	{
        try
        {
        	HttpComponent httpComp = new HttpComponent();
        	String requestUrl = feedUrl + interfaceURL;
    		CloseableHttpClient clientservice = provider.getHttpClient();
    		String result = httpComp.get(clientservice, requestUrl);
    		
    		if(StringUtil.isNullOrEmpty(result))
    			return null;
    		
    		return result;
    		
        }
        catch(Exception e)
        {
        	GlobalObject.ERROR_LOG.error("Tools.getHttpInfo", e);
        	return null;
        }
	}
	
	public static String postHttpInfo(String feedUrl, HttpClientProvider provider,String interfaceURL, JSONObject postData) 
	{
        try
        {
        	HttpComponent httpComp = new HttpComponent();
        	String requestUrl = feedUrl + interfaceURL;
    		CloseableHttpClient clientservice = provider.getHttpClient();
    		String result = httpComp.post(clientservice, requestUrl, postData.toString());
    
    		if(StringUtil.isNullOrEmpty(result))
    			return null;
    		
    		return result;
    		
        }
        catch(Exception e)
        {
        	GlobalObject.ERROR_LOG.error("Tools.postHttpInfo", e);
        	return null;
        }
	}
	
	public static  String encodetoAtom(String uid)
    {	
		if (Constant.TEST_FLG) {
			uid = "129707";
		}
		String atom = "";
		if (null != uid ) {
			uid = Constant.STR_UID_CODE + uid;
			atom = new String(Base64.encodeBase64(uid.getBytes()));
			atom = Constant.STR_ATOM_MARK +atom ;
		  }
	  return atom;
    }
	
	public static  String editURLParameter(String name, String content)
    {
		String[] names = name.split(Constant.STR_COMMA);
		String[] contents = content.split(Constant.STR_COMMA);
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < names.length; i++)
		{
			result.append(names[i]);
			result.append(Constant.STR_EQUAL);
			result.append(contents[i]);
			result.append(Constant.STR_AND);
		}
		
		result.replace(result.length() - 1, result.length(), Constant.STR_BLANK);
		
        return result.toString();
    }
	
	public static void renderData(HttpServletResponse response, JSONObject data) {
	    	PrintWriter printWriter = null;
	    try {
		      printWriter = response.getWriter();
		      printWriter.print(data);
	    } catch (IOException e) {
	    	GlobalObject.ERROR_LOG.error("Tools.renderData", e);
	    } finally {
		      if (null != printWriter) {
		        printWriter.flush();
		        printWriter.close();
		      }
	    }
	  }
	
	public static List<Integer> editPageNumber(int total, int selectPage) {
		int totalPage = total/Constant.PAGE_SIZE;
		if(total % Constant.PAGE_SIZE != 0){
		    totalPage += 1;
		}
		Vector<Integer> pageArr = new Vector<Integer>();
		int start = 1;
		if(selectPage >= 10){
		     start = selectPage/10 * 10;
		 }
		int num = start;
		while(!(num > totalPage || num > start + 10)){
		     pageArr.add(new Integer(num));
		    ++num;
		}
		return pageArr;
	}
	
	public static List<Integer> editPageNumber(int total, int selectPage, int pageSize) {
		int totalPage = total/pageSize;
		if(total % pageSize != 0){
		    totalPage += 1;
		}
		List<Integer> pageArr = new ArrayList<Integer>();
		int start = 1;
		if(selectPage >= 4){
		     start = selectPage/4 * 4;
		 }
		int num = start;
		while(!(num > totalPage || num > start + 4)){
		     pageArr.add(num);
		    ++num;
		}
		return pageArr;
	}
	
	public static int editTotalPageNumber(int total) {
		int totalPage = total/Constant.PAGE_SIZE;
		if(total % Constant.PAGE_SIZE != 0){
		    totalPage += 1;
		}
		if (total == 0) 
			totalPage = 1;
		return totalPage;
	}
	
	public static String replaceBlank(String page) {
		if (null != page) {
			return page.replace(" ", "");
		} else {
			return "";
		}
	}
	
	public static String getAtom() {
		String atom = "dWlkPTYwODU5OCZzaWQ9ZTNjMmJiMmIzOWE3OGU3MCZjYz0xMDAwMCZwZj1hbmRyb2lkJmNuPVdJRkkmY3Y9TUdBXzEuMC4wLjAwX0FfQ04mZHQ9WGlhb21pMjAxMzAyMiZpbWVpPTg2NDgwNTAyMTc1NzUyOCZpbXNpPSZwbj0%3D";
		return atom;
	}
	
}
