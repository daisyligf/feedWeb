package com.mofang.feedweb.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;

public class Tools {

	public static String encodetoAtom(String uid) {
		if (Constant.TEST_FLG && StringUtil.isNullOrEmpty(uid)) {
			uid = "129707";
		}
		String atom = "";
		uid = Constant.STR_UID_CODE + uid;
		atom = Constant.STR_ATOM_MARK
				+ new String(Base64.encodeBase64(uid.getBytes()));
		return atom;
	}

	public static String editURLParameter(String name, String content) {
		String[] names = name.split(Constant.STR_COMMA);
		String[] contents = content.split(Constant.STR_COMMA);
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < names.length; i++) {
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
		int totalPage = total / Constant.PAGE_SIZE;
		if (total % Constant.PAGE_SIZE != 0) {
			totalPage += 1;
		}
		Vector<Integer> pageArr = new Vector<Integer>();
		int start = 1;
		if (selectPage >= 10) {
			start = selectPage / 10 * 10;
		}
		int num = start;
		while (!(num > totalPage || num > start + 10)) {
			pageArr.add(new Integer(num));
			++num;
		}
		return pageArr;
	}

	public static List<Integer> editPageNumber(int total, int selectPage,
			int pageSize) {
		int totalPage = total / pageSize;
		if (total % pageSize != 0) {
			totalPage += 1;
		}
		List<Integer> pageArr = new ArrayList<Integer>();
		int front_block = selectPage - 5;// 当前页码前面一截
		int back_block = selectPage + 5;// 当前页码后面一截
		// 有多页
		int tempBack_block = totalPage;
		int tempFront_block = 1;
		if (back_block < totalPage)
			tempBack_block = back_block;
		if (front_block > 1)
			tempFront_block = front_block;

		for (int i = tempFront_block; i <= tempBack_block; i++) {
			pageArr.add(i);
		}

		return pageArr;
	}
	
	/*
	 * total:列表信息的总行数
	 * selectPage:当前选择页
	 * pageSize:每页表示的最大行数
	 * viewPages 页码列表的当前页码前后表示的页码数。
	 * 
	*/
	public static List<Integer> editPageNumber(int total, int selectPage,
			int pageSize, int viemPages) {
		int totalPage = total / pageSize;
		if (total % pageSize != 0) {
			totalPage += 1;
		}
		List<Integer> pageArr = new ArrayList<Integer>();
		int front_block = selectPage - viemPages;// 当前页码前面一截
		int back_block = selectPage + viemPages;// 当前页码后面一截
		// 有多页
		int tempBack_block = totalPage;
		int tempFront_block = 1;
		if (back_block < totalPage)
			tempBack_block = back_block;
		if (front_block > 1)
			tempFront_block = front_block;
		
		//把首页加入页表
		if (front_block > 1) {
			pageArr.add(0);
		}
		for (int i = tempFront_block; i <= tempBack_block; i++) {
			pageArr.add(i);
		}
		
		//把尾页加入列表
		if (back_block < totalPage) {
			pageArr.add(-1);
		}
		return pageArr;
	}

	public static int editTotalPageNumber(int total) {
		int totalPage = total / Constant.PAGE_SIZE;
		if (total % Constant.PAGE_SIZE != 0) {
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

	public static boolean hasPic(JSONArray pics, String htmlContent) {
		if (pics != null && pics.length() > 0) {
			return true;
		} else {
			Pattern pattern = Pattern.compile("<img.*src=(.*?)[^>]*?>");
			Matcher matcher = pattern.matcher(htmlContent);
			return matcher.find();
		}
	}
	
}
