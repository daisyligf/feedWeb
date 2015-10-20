package com.mofang.feedweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.entity.FeedHomeLinkUrl;
import com.mofang.feedweb.entity.FeedHomeListHotForum;
import com.mofang.feedweb.entity.FeedHomeListRecommendGame;
import com.mofang.feedweb.form.FeedForumOfficalForm;
import com.mofang.feedweb.form.FeedHomeHotForumRankForm;
import com.mofang.feedweb.form.FeedHomeListRecommendGameForm;
import com.mofang.feedweb.form.FeedHomeRecommendGameRankForm;
import com.mofang.feedweb.form.FeedHomeSubjectForm;
import com.mofang.feedweb.form.FeedHomeTickerForm;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;

@Controller
public class FeedHomeController extends FeedCommonController {
	
	
	// home主页初期信息显示
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try{
			//友情链接
			model.put("linkInfo", getLinkUrl(request));
			//检索关键字
			model.put("keyword", getSearchKey(request));
			//海报
			model.put("tickers", getHomeTickers(request));
			//大小标题
			model.put("subjects", getHomeSubjects(request));
			//热游推荐榜单
			model.put("hotRank", getHomeHotForumRank(request));
			//新游推荐榜单
			model.put("recommendRank", getHomeRecommendRank(request));
			//热游版块
			model.put("hotForumList", getHomeListHotForum(request));
			//新游版块
			model.put("recommendForumList", getHomeListRecommendForum(request));
			//官方版块
			model.put("officalForum", getHomeOfficalForum(request));
			
			return new ModelAndView("index", model);
			
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.home throw an error.", e);
			return new ModelAndView("index", model);
		}
		

	}
	
	private List<FeedHomeLinkUrl> getLinkUrl(HttpServletRequest request) throws JSONException {
		
		List<FeedHomeLinkUrl> list= new ArrayList<FeedHomeLinkUrl>();
		
		JSONObject result = getHttpInfo(getLinkUrl(), "" , request);
		
		if (null != result) {
			int code = result.optInt("code", -1);
			if (0 == code) {
				JSONArray data = result.optJSONArray("data");
				FeedHomeLinkUrl linkurl = null;
				JSONObject json = null;
				if (null != data) {
					for (int i=0; i<data.length(); i++) {
						json = data.getJSONObject(i);
						linkurl = new FeedHomeLinkUrl();
						linkurl.setLinkUrl(json.optString("url", ""));
						linkurl.setLinkName(json.optString("name", ""));
						list.add(linkurl);
					}
				}
			}
			
		}
		
		return list;
		
	}
	private FeedHomeTickerForm getHomeTickers(
			HttpServletRequest request) throws JSONException {
		
		FeedHomeTickerForm tickerForm = new FeedHomeTickerForm();
		
		try {
			//海报
			JSONObject tickersResult = getHttpInfo(getFeedUrlInfo().concat(
					Constant.TICKER_INFO_GET_URL),"" , request);
			
			if (null != tickersResult) {
				
				int code = tickersResult.optInt("code", -1);
				if (0 != code) {
				} else {
					
					JSONArray data = tickersResult.optJSONArray("data");
					JSONObject jsonNewsPaper = null;
					for(int i=0; i<data.length(); i++)
					{
						jsonNewsPaper = data.getJSONObject(i);
						if (i == 0) {
							tickerForm.setTickerIcon1(jsonNewsPaper.optString("icon", ""));
							tickerForm.setThreadLink1(jsonNewsPaper.optString("link_url", ""));
						} else if (i == 1) {
							tickerForm.setTickerIcon2(jsonNewsPaper.optString("icon", ""));
							tickerForm.setThreadLink2(jsonNewsPaper.optString("link_url", ""));
						} else if (i == 2) {
							tickerForm.setTickerIcon3(jsonNewsPaper.optString("icon", ""));
							tickerForm.setThreadLink3(jsonNewsPaper.optString("link_url", ""));
						}
					}
				}	
				
			}
			
			return tickerForm;
			
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.getHomeTickers throw an error.", e);
			return tickerForm;
		}
		
	}
	
	private FeedHomeSubjectForm getHomeSubjects(
			HttpServletRequest request) throws JSONException {
		
		FeedHomeSubjectForm subjectForm = new FeedHomeSubjectForm();
		
		try {
			//大小标题
			JSONObject subjectResult = getHttpInfo(getFeedUrlInfo().concat(
					Constant.SUBJECT_INFO_GET_URL),"" , request);
			
			if (null != subjectResult) {
			
				int code = subjectResult.optInt("code", -1);
				
				if(0 != code) {
				} else {
					JSONArray data = subjectResult.optJSONArray("data");
					JSONObject jsonThreadsTitle = null;
					for(int i=0; i<data.length(); i++) {
						jsonThreadsTitle = data.getJSONObject(i);
						if (i == 0) {
							subjectForm.setThreadId1(jsonThreadsTitle.optLong("thread_id",0));
							if (jsonThreadsTitle.optString("subject","").length() > 28) {
								subjectForm.setThreadName1(jsonThreadsTitle.optString("subject","").substring(0, 28));
							} else {
								subjectForm.setThreadName1(jsonThreadsTitle.optString("subject",""));
							}
							if (jsonThreadsTitle.optString("content","").length() > 63) {
								subjectForm.setContent1(jsonThreadsTitle.optString("content","").substring(0, 63));
							} else {
								subjectForm.setContent1(jsonThreadsTitle.optString("content",""));
							}
							subjectForm.setLinkUrl1(jsonThreadsTitle.optString("link_url",""));
							subjectForm.setForumId1(jsonThreadsTitle.optLong("forum_id",0));
							subjectForm.setForumNmae1(jsonThreadsTitle.optString("forum_name",""));
						} else if (i == 1) {
							subjectForm.setThreadId2(jsonThreadsTitle.optLong("thread_id",0));
							if (jsonThreadsTitle.optString("subject","").length() > 28) {
								subjectForm.setThreadName2(jsonThreadsTitle.optString("subject","").substring(0, 28));
							} else {
								subjectForm.setThreadName2(jsonThreadsTitle.optString("subject",""));
							}
							if (jsonThreadsTitle.optString("content","").length() > 63) {
								subjectForm.setContent2(jsonThreadsTitle.optString("content","").substring(0, 63));
							} else {
								subjectForm.setContent2(jsonThreadsTitle.optString("content",""));
							}
							subjectForm.setLinkUrl2(jsonThreadsTitle.optString("link_url",""));
							subjectForm.setForumId2(jsonThreadsTitle.optLong("forum_id",0));
							subjectForm.setForumNmae2(jsonThreadsTitle.optString("forum_name",""));
						} else if (i == 2) {
							subjectForm.setThreadId3(jsonThreadsTitle.optLong("thread_id",0));
							if (jsonThreadsTitle.optString("subject","").length() > 15) {
								subjectForm.setThreadName3(jsonThreadsTitle.optString("subject","").substring(0, 15));
							} else {
								subjectForm.setThreadName3(jsonThreadsTitle.optString("subject",""));
							}
							if (jsonThreadsTitle.optString("content","").length() > 20) {
								subjectForm.setContent3(jsonThreadsTitle.optString("content","").substring(0, 20));
							} else {
								subjectForm.setContent3(jsonThreadsTitle.optString("content",""));
							}
							subjectForm.setLinkUrl3(jsonThreadsTitle.optString("link_url",""));
							subjectForm.setForumId3(jsonThreadsTitle.optLong("forum_id",0));
							subjectForm.setForumNmae3(jsonThreadsTitle.optString("forum_name",""));
						} else if (i == 3) {
							subjectForm.setThreadId4(jsonThreadsTitle.optLong("thread_id",0));
							if (jsonThreadsTitle.optString("subject","").length() > 20) {
								subjectForm.setThreadName4(jsonThreadsTitle.optString("subject","").substring(0, 20));
							} else {
								subjectForm.setThreadName4(jsonThreadsTitle.optString("subject",""));
							}
							if (jsonThreadsTitle.optString("content","").length() > 20) {
								subjectForm.setContent4(jsonThreadsTitle.optString("content","").substring(0, 20));
							} else {
								subjectForm.setContent4(jsonThreadsTitle.optString("content",""));
							}
							subjectForm.setLinkUrl4(jsonThreadsTitle.optString("link_url",""));
							subjectForm.setForumId4(jsonThreadsTitle.optLong("forum_id",0));
							if (jsonThreadsTitle.optString("forum_name","").length() > 10) {
								subjectForm.setForumNmae4(jsonThreadsTitle.optString("forum_name","").substring(0, 10));
							} else {
								subjectForm.setForumNmae4(jsonThreadsTitle.optString("forum_name",""));
							}
						} else if (i == 4) {
							subjectForm.setThreadId5(jsonThreadsTitle.optLong("thread_id",0));
							if (jsonThreadsTitle.optString("subject","").length() > 20) {
								subjectForm.setThreadName5(jsonThreadsTitle.optString("subject","").substring(0, 20));
							} else {
								subjectForm.setThreadName5(jsonThreadsTitle.optString("subject",""));
							}
							if (jsonThreadsTitle.optString("content","").length() > 20) {
								subjectForm.setContent5(jsonThreadsTitle.optString("content","").substring(0, 20));
							} else {
								subjectForm.setContent5(jsonThreadsTitle.optString("content",""));
							}
							subjectForm.setLinkUrl5(jsonThreadsTitle.optString("link_url",""));
							subjectForm.setForumId5(jsonThreadsTitle.optLong("forum_id",0));
							if (jsonThreadsTitle.optString("forum_name","").length() > 10) {
								subjectForm.setForumNmae5(jsonThreadsTitle.optString("forum_name","").substring(0, 10));
							} else {
								subjectForm.setForumNmae5(jsonThreadsTitle.optString("forum_name",""));
							}
						} else if (i == 5) {
							subjectForm.setThreadId6(jsonThreadsTitle.optLong("thread_id",0));
							if (jsonThreadsTitle.optString("subject","").length() > 20) {
								subjectForm.setThreadName6(jsonThreadsTitle.optString("subject","").substring(0, 20));
							} else {
								subjectForm.setThreadName6(jsonThreadsTitle.optString("subject",""));
							}
							if (jsonThreadsTitle.optString("content","").length() > 20) {
								subjectForm.setContent6(jsonThreadsTitle.optString("content","").substring(0, 20));
							} else {
								subjectForm.setContent6(jsonThreadsTitle.optString("content",""));
							}
							subjectForm.setLinkUrl6(jsonThreadsTitle.optString("link_url",""));
							subjectForm.setForumId6(jsonThreadsTitle.optLong("forum_id",0));
							if (jsonThreadsTitle.optString("forum_name","").length() > 10) {
								subjectForm.setForumNmae6(jsonThreadsTitle.optString("forum_name","").substring(0, 10));
							} else {
								subjectForm.setForumNmae6(jsonThreadsTitle.optString("forum_name",""));
							}
						} else if (i == 6) {
							subjectForm.setThreadId7(jsonThreadsTitle.optLong("thread_id",0));
							if (jsonThreadsTitle.optString("subject","").length() > 20) {
								subjectForm.setThreadName7(jsonThreadsTitle.optString("subject","").substring(0, 20));
							} else {
								subjectForm.setThreadName7(jsonThreadsTitle.optString("subject",""));
							}
							if (jsonThreadsTitle.optString("content","").length() > 20) {
								subjectForm.setContent7(jsonThreadsTitle.optString("content","").substring(0, 20));
							} else {
								subjectForm.setContent7(jsonThreadsTitle.optString("content",""));
							}
							subjectForm.setLinkUrl7(jsonThreadsTitle.optString("link_url",""));
							subjectForm.setForumId7(jsonThreadsTitle.optLong("forum_id",0));
							if (jsonThreadsTitle.optString("forum_name","").length() > 10) {
								subjectForm.setForumNmae7(jsonThreadsTitle.optString("forum_name","").substring(0, 10));
							} else {
								subjectForm.setForumNmae7(jsonThreadsTitle.optString("forum_name",""));
							}
						}
					}
				}
			}
			return subjectForm;
			
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.getHomeSubjects throw an error.", e);
			return subjectForm;
		}
		
	}
	
	private FeedHomeHotForumRankForm getHomeHotForumRank(
			HttpServletRequest request) throws JSONException {
		
		
		FeedHomeHotForumRankForm objHotForumrank = new FeedHomeHotForumRankForm();
		try {
			//热门版块榜单
			JSONObject hotForumRankResult = getHttpInfo(
					getFeedUrlInfo().concat(
							Constant.HOT_FOURM_RANK_GET_URL),"" , request);
			if (null != hotForumRankResult) {
				
				int code = hotForumRankResult.optInt("code", -1);
				if(0 != code) {
				} else {
					
					JSONArray data = hotForumRankResult.optJSONArray("data");
					
					JSONObject jsonRank = null;
					for(int i=0; i<data.length(); i++)
					{
						jsonRank = data.getJSONObject(i);
						if (i == 0) {
							objHotForumrank.setForumId1(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 8) {
								objHotForumrank.setForumName1(jsonRank.optString("forum_name", "").substring(0, 8));
							} else {
								objHotForumrank.setForumName1(jsonRank.optString("forum_name", ""));
							}
							objHotForumrank.setIcon1(jsonRank.optString("icon", ""));
							objHotForumrank.setUpDown1(jsonRank.optInt("up_down", 0));
						} else if (i == 1) {
							objHotForumrank.setForumId2(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 8) {
								objHotForumrank.setForumName2(jsonRank.optString("forum_name", "").substring(0, 8));
							} else {
								objHotForumrank.setForumName2(jsonRank.optString("forum_name", ""));
							}
							objHotForumrank.setIcon2(jsonRank.optString("icon", ""));
							objHotForumrank.setUpDown2(jsonRank.optInt("up_down", 0));
						} else if (i == 2) {
							objHotForumrank.setForumId3(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 8) {
								objHotForumrank.setForumName3(jsonRank.optString("forum_name", "").substring(0, 8));
							} else {
								objHotForumrank.setForumName3(jsonRank.optString("forum_name", ""));
							}
							objHotForumrank.setIcon3(jsonRank.optString("icon", ""));
							objHotForumrank.setUpDown3(jsonRank.optInt("up_down", 0));
						} else if (i == 3) {
							objHotForumrank.setForumId4(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 8) {
								objHotForumrank.setForumName4(jsonRank.optString("forum_name", "").substring(0, 8));
							} else {
								objHotForumrank.setForumName4(jsonRank.optString("forum_name", ""));
							}
							objHotForumrank.setIcon4(jsonRank.optString("icon", ""));
							objHotForumrank.setUpDown4(jsonRank.optInt("up_down", 0));
						} else if (i == 4) {
							objHotForumrank.setForumId5(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 8) {
								objHotForumrank.setForumName5(jsonRank.optString("forum_name", "").substring(0, 8));
							} else {
								objHotForumrank.setForumName5(jsonRank.optString("forum_name", ""));
							}
							objHotForumrank.setIcon5(jsonRank.optString("icon", ""));
							objHotForumrank.setUpDown5(jsonRank.optInt("up_down", 0));
						}
					}
				}
				
			}
			return objHotForumrank;
			
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.getHomeHotForumRank throw an error.", e);
			return objHotForumrank;
		}
		
	}
	
	private FeedHomeRecommendGameRankForm getHomeRecommendRank(
			HttpServletRequest request) throws JSONException {
		
		FeedHomeRecommendGameRankForm recommendRank = new FeedHomeRecommendGameRankForm();
		
		try {
			//新游推荐榜单
			JSONObject hotForumRankResult = getHttpInfo(
					getFeedUrlInfo().concat(
							Constant.RECOMMEND_GAME_RANK_GET_URL),"" , request);
			if (null != hotForumRankResult) {
				
				int code = hotForumRankResult.optInt("code", -1);
				if(0 != code) {
				} else {
				
					JSONArray data = hotForumRankResult.optJSONArray("data");
					
					JSONObject jsonRank = null;
					for(int i=0; i<data.length(); i++)
					{
						jsonRank = data.getJSONObject(i);
						if (i == 0) {
							recommendRank.setForumId1(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 6) {
								recommendRank.setForumName1(jsonRank.optString("forum_name", "").substring(0, 6));
							} else {
								recommendRank.setForumName1(jsonRank.optString("forum_name", ""));
							}
							
							recommendRank.setIcon1(jsonRank.optString("icon", ""));
							recommendRank.setDownLoadUrl1(jsonRank.optString("download_url", ""));
							recommendRank.setGiftUrl1(jsonRank.optString("gift_url", ""));
						} else if (i == 1) {
							recommendRank.setForumId2(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 6) {
								recommendRank.setForumName2(jsonRank.optString("forum_name", "").substring(0, 6));
							} else {
								recommendRank.setForumName2(jsonRank.optString("forum_name", ""));
							}
							
							recommendRank.setIcon2(jsonRank.optString("icon", ""));
							recommendRank.setDownLoadUrl2(jsonRank.optString("download_url", ""));
							recommendRank.setGiftUrl2(jsonRank.optString("gift_url", ""));
						} else if (i == 2) {
							recommendRank.setForumId3(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 6) {
								recommendRank.setForumName3(jsonRank.optString("forum_name", "").substring(0, 6));
							} else {
								recommendRank.setForumName3(jsonRank.optString("forum_name", ""));
							}
							
							recommendRank.setIcon3(jsonRank.optString("icon", ""));
							recommendRank.setDownLoadUrl3(jsonRank.optString("download_url", ""));
							recommendRank.setGiftUrl3(jsonRank.optString("gift_url", ""));
						} else if (i == 3) {
							recommendRank.setForumId4(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 6) {
								recommendRank.setForumName4(jsonRank.optString("forum_name", "").substring(0, 6));
							} else {
								recommendRank.setForumName4(jsonRank.optString("forum_name", ""));
							}
							
							recommendRank.setIcon4(jsonRank.optString("icon", ""));
							recommendRank.setDownLoadUrl4(jsonRank.optString("download_url", ""));
							recommendRank.setGiftUrl4(jsonRank.optString("gift_url", ""));
						} else if (i == 4) {
							recommendRank.setForumId5(jsonRank.optLong("forum_id", 0));
							if (jsonRank.optString("forum_name", "").length() > 6) {
								recommendRank.setForumName5(jsonRank.optString("forum_name", "").substring(0, 6));
							} else {
								recommendRank.setForumName5(jsonRank.optString("forum_name", ""));
							}
							
							recommendRank.setIcon5(jsonRank.optString("icon", ""));
							recommendRank.setDownLoadUrl5(jsonRank.optString("download_url", ""));
							recommendRank.setGiftUrl5(jsonRank.optString("gift_url", ""));
						}
					}
				}
				
			}
			return recommendRank;
			
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.getHomeRecommendRank throw an error.", e);
			return recommendRank;
		}
		
	}
	
	private List<FeedHomeListHotForum> getHomeListHotForum(HttpServletRequest request)
			throws JSONException {
		
		List<FeedHomeListHotForum> list = new ArrayList<FeedHomeListHotForum>();
		try {
			//热门游戏版块list
			JSONObject listHotGameResult = getHttpInfo(
					getFeedUrlInfo().concat(
							Constant.LIST_HOT_FOURM_GET_URL),"" , request);
			if (null != listHotGameResult) {
				
				int code = listHotGameResult.optInt("code", -1);
				if(0 == code) {
					
					JSONArray data = listHotGameResult.optJSONArray("data");
					JSONObject jsonHotGame = null;
					FeedHomeListHotForum objHotGame = null;
					for(int i=0; i<data.length(); i++)
					{
						jsonHotGame = data.getJSONObject(i);
						objHotGame = new FeedHomeListHotForum();
						objHotGame.setHotForumId(jsonHotGame.optLong("forum_id", 0));
						if (jsonHotGame.optString("forum_name", "").length() > 8) {
							objHotGame.setHotForumName(jsonHotGame.optString("forum_name", "").substring(0, 8));
						} else {
							objHotGame.setHotForumName(jsonHotGame.optString("forum_name", ""));
						}
						objHotGame.setHotIcon(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl(jsonHotGame.optString("gift_url", ""));
						list.add(objHotGame);
					}
					
				}
			}
			return list;
			
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.getHomeListHotForum throw an error.", e);
			return list;
		}
		
	}
	
	private List<FeedHomeListRecommendGame> getHomeListRecommendForum(
			HttpServletRequest request) throws JSONException {
		
		List<FeedHomeListRecommendGame> list = new ArrayList<FeedHomeListRecommendGame>();
		
		try {
			JSONObject listRecommendGameResult = getHttpInfo(
					getFeedUrlInfo().concat(
							Constant.LIST_RECOMMENDGAME_GET_URL),"" , request);
			if (null != listRecommendGameResult) {
				
				int code = listRecommendGameResult.optInt("code", -1);
				if(0 == code) {
					
					JSONArray data = listRecommendGameResult.optJSONArray("data");
					JSONObject jsonGame = null;
					FeedHomeListRecommendGame form = null;
					for(int i=0; i<data.length(); i++)
					{
						jsonGame = data.getJSONObject(i);
						form = new FeedHomeListRecommendGame();
						form.setForumId(jsonGame.optLong("forum_id", 0));
						if (jsonGame.optString("forum_name", "").length() > 8) {
							form.setForumName(jsonGame.optString("forum_name", "").substring(0, 8));
						} else {
							form.setForumName(jsonGame.optString("forum_name", ""));
						}
						form.setIcon(jsonGame.optString("icon", ""));
						form.setTodayThreads(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl(jsonGame.optString("download_url", ""));
						form.setGiftUrl(jsonGame.optString("gift_url", ""));
						list.add(form);
					}
				}
				
			} 
			return list;
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.getHomeListRecommendForum throw an error.", e);
			return list;
		}
		
	}
	
	private FeedForumOfficalForm getHomeOfficalForum(
			HttpServletRequest request) throws JSONException {
		
		FeedForumOfficalForm form = new FeedForumOfficalForm();
		
		try {
			//官方版块
			JSONObject officalResult = getHttpInfo(
					getFeedUrlInfo().concat(
							Constant.PREFECTURE_INFO_GET_URL),"" , request);
			if (null != officalResult) {
				
				int code = officalResult.optInt("code", -1);
				if(0 != code) {
				} else {
					
					JSONArray data = officalResult.optJSONArray("data");
					JSONObject json = null;
					for(int i=0; i<data.length(); i++)
					{
						json = data.getJSONObject(i);
						if (i == 0) {
							form.setForumId1(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName1(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName1(json.optString("forum_name", ""));
							}
							form.setIcon1(json.optString("icon", ""));
							form.setTodayThreads1(json.optInt("today_threads", 0));
							form.setTotalThreads1(json.optInt("total_threads", 0));
						} else if (i == 1) {
							form.setForumId2(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName2(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName2(json.optString("forum_name", ""));
							}
							form.setIcon2(json.optString("icon", ""));
							form.setTodayThreads2(json.optInt("today_threads", 0));
							form.setTotalThreads2(json.optInt("total_threads", 0));
						} else if (i == 2) {
							form.setForumId3(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName3(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName3(json.optString("forum_name", ""));
							}
							form.setIcon3(json.optString("icon", ""));
							form.setTodayThreads3(json.optInt("today_threads", 0));
							form.setTotalThreads3(json.optInt("total_threads", 0));
						} else if (i == 3) {
							form.setForumId4(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName4(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName4(json.optString("forum_name", ""));
							}
							form.setIcon4(json.optString("icon", ""));
							form.setTodayThreads4(json.optInt("today_threads", 0));
							form.setTotalThreads4(json.optInt("total_threads", 0));
						}
						
					}
					
				}
				
			}
			return form;
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedHomeController.getHomeOfficalForum throw an error.", e);
			return form;
		}
		
	}
}
