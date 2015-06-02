package com.mofang.feedweb.form;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author ke
 * 
 */
public class FeedHomeTickerForm {

	private String ticker_icon1;
	private String thread_link1;
	private String ticker_icon2;
	private String thread_link2;
	private String ticker_icon3;
	private String thread_link3;
	
	
	public String getTicker_icon1() {
		return ticker_icon1;
	}
	public void setTicker_icon1(String ticker_icon1) {
		this.ticker_icon1 = ticker_icon1;
	}
	public String getThread_link1() {
		return thread_link1;
	}
	public void setThread_link1(String thread_link1) {
		this.thread_link1 = thread_link1;
	}
	public String getTicker_icon2() {
		return ticker_icon2;
	}
	public void setTicker_icon2(String ticker_icon2) {
		this.ticker_icon2 = ticker_icon2;
	}
	public String getThread_link2() {
		return thread_link2;
	}
	public void setThread_link2(String thread_link2) {
		this.thread_link2 = thread_link2;
	}
	public String getTicker_icon3() {
		return ticker_icon3;
	}
	public void setTicker_icon3(String ticker_icon3) {
		this.ticker_icon3 = ticker_icon3;
	}
	public String getThread_link3() {
		return thread_link3;
	}
	public void setThread_link3(String thread_link3) {
		this.thread_link3 = thread_link3;
	}

	public JSONObject toJson()
	{
		try
		{
			JSONObject json = new JSONObject();
			JSONArray data = new JSONArray();
			json.put("icon", ticker_icon1);
			json.put("link_url", thread_link1);
			data.put(json);
			json = new JSONObject();
			json.put("icon", ticker_icon2);
			json.put("link_url", thread_link2);
			data.put(json);
			json = new JSONObject();
			json.put("icon", ticker_icon3);
			json.put("link_url", thread_link3);
			data.put(json);
			json = new JSONObject();
			json.putOpt("data", data);
			return json;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
