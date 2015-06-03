package com.mofang.feedweb.global;

public class Constant {

	// atom问号
	public static final String STR_ATOM_MARK = "atom=";
	// uid
	public static final String STR_UID_CODE = "uid=";
	// 列表页面表示行数
	public static final int PAGE_SIZE = 20;
	// 用户ID
	public static final String SESSION_USERID = "userID";
	// 用户名字
	public static final String SESSION_USERNAME = "userName";
	// 逗号
	public static final String STR_COMMA = ",";
	// 与
	public static final String STR_AND = "&";
	// 等号
	public static final String STR_EQUAL = "=";
	// 空白
	public static final String STR_BLANK = "";
	// 问号
	public static final String STR_QUESTION_MARK = "?";
	// 用户session
	public static final String SESSION_USER = "sessionUser";
	// 用户session
	public static final String SESSION_OPERATORID = "sessionOperatorID";
	// 字母ABCDE
	public static final String STR_ABCDE = "ABCDE";
	// 字母FGHIJ
	public static final String STR_FGHIJ = "FGHIJ";
	// 字母KLMNO
	public static final String STR_KLMNO = "KLMNO";
	// 字母PQRST
	public static final String STR_PQRST = "PQRST";
	// 字母WXYZ
	public static final String STR_WXYZ = "WXYZ";
	// 字母#(其它)
	public static final String STR_OTHER = "#";
	//上传图片地址
	public static final String UPLOAD_URL = "http://api.mofang.com/mcss/v1/upload";

	public static final boolean TEST_FLG = false;

	// 帖子详情页
	// 楼层列表

	public static final String THREAD_POSTLIST_GET_URL = "/feed/v2/web/floorlist";
	// 楼层评论列表

	public static final String THREAD_COMMENTLIST_GET_URL = "/feed/v2/web/commentdisplay";
	// 新增楼层

	public static final String POST_CREATE_URL = "/feed/v2/web/sendreply";
	// 回复指定楼层

	public static final String POST_REPLY_URL = "/feed/v2/web/sendcomment";
	// 帖子管理-删除

	public static final String THREAD_DELETE_URL = "/feed/v2/web/removethread";
	// 帖子管理-加精

	public static final String THREAD_SETELITE_URL = "/feed/v2/web/thread/tag";
	// 帖子管理-取消加精

	public static final String THREAD_CANCELELITE_URL = "/feed/v2/web/thread/tag/cancel";
	// 帖子管理-置顶

	public static final String THREAD_SETTOP_URL = "/feed/v2/web/thread/top";
	// 帖子管理-取消置顶

	public static final String THREAD_CANCELTOP_URL = "/feed/v2/web/thread/canceltop";
	// 帖子管理-锁帖

	public static final String THREAD_CLOSE_URL = "/feed/v2/web/threads/close";
	// 帖子管理-取消锁帖

	public static final String THREAD_OPEN_URL = "/feed/v2/web/threads/open";
	// 楼层删除

	public static final String POST_DELETE_URL = "/feed/v2/web/floor/del";
	// 楼层点赞

	public static final String POST_COMMEND_URL = "/feed/v2/web/floor/hotreply_add";
	// 最热推荐

	public static final String HOST_RECOMMEND_URL = "/feed/v2/web/floor/hotRecommend";

	// 板块内容页
	// 帖子列表

	public static final String LIST_THREAD_GET_URL = "/feed/v2/web/thread/list";
	// 板块信息

	public static final String FORUM_INFO_GET_URL = "/feed/v2/web/forum/info";
	// 吧主信息

	public static final String LIST_MODERATOR_GET_URL = "/feed/v2/web/forum/roleInfoList";
	// 关注板块

	public static final String FORUM_FOLLOW_URL = "/feed/v2/web/forum/follow";
	// 取消关注板块

	public static final String FORUM_CANCELFOLLOW_URL = "/feed/v2/web/forum/follow/cancel";

	// 搜索页
	// 板块搜索
	public static final String LIST_FORUM_SEARCH_URL = "/feed/v2/web/forum/search";
	// 帖子搜索
	public static final String LIST_THREAD_SEARCH_URL = "/feed/v2/web/thread/search";

	// 发帖页
	// 发帖
	public static final String THREAD_CREATE_URL = "/feed/v2/web/newthread";
	// 楼主信息
	public static final String THREAD_MODERATOR_INFO_URL = "/feed/v2/web/user/info";
	// 版块标签
	public static final String FORUM_TAG_LIST_URL = "/feed/v2/web/forum/taglist"; 
	// 帖子详情
	public static final String THREAD_INFO_URL = "/feed/v2/web/thread/info"; 
	// 帖子-编辑更新
	public static final String THREAD_EDIT_URL = "/feed/v2/web/thread/edit";

	// 板块列表页
	// 板块列表
	public static final String LIST_FORUM_GET_URL = "/feed/v2/web/forum/listByLetterGroup";

	// 首页
	// 轮播海报
	public static final String TICKER_INFO_GET_URL = "/feed/v2/home/ticker";
	// 首页头条
	public static final String SUBJECT_INFO_GET_URL = "/feed/v2/home/threads";
	// 热游排行榜
	public static final String HOT_FOURM_RANK_GET_URL = "/feed/v2/home/hotForumRank";
	// 新游排行榜

	public static final String RECOMMEND_GAME_RANK_GET_URL = "/feed/v2/home/recommendGameRank";
	// 热游列表
	public static final String LIST_HOT_FOURM_GET_URL = "/feed/v2/home/hotForumList";
	// 新游列表
	public static final String LIST_RECOMMENDGAME_GET_URL = "/feed/v2/home/recommendGameList";
	// 综合专区
	public static final String PREFECTURE_INFO_GET_URL = "/feed/v2/home/prefecture";
	// 搜索关键字
	public static final String HOME_SEARCH_KEYWORD_GET_URL = "/feed/v2/home/keyworkd";

	// 普通用户
	// 用户详情
	public static final String USER_INFO_URL = "/feed/v2/backend/user/info";
	// 用户禁言
	public static final String USER_SETPROHIBIT_URL = "/feed/v2/backend/user/setprohibit";
	// 用户取消禁言
	public static final String USER_CANCELPROHIBIT_URL = "/feed/v2/backend/user/cancelprohibit";
	// 用户删除
	// 用户恢复
	// 用户批量恢复

	// 外部接口
	// 图片上传
	public static final String IMAGE_UPLOAD_URL = "/mcss/v1/upload";
	// 用户logout
	public static final String USER_LOGOUT_URL = "/account/logout";
	// 用户登录
	public static final String USER_LOGIN_URL = "/api/login";
	// 礼包列表
	public static final String GIFT_LIST_URL = "/api/v1/gift/list";
	// 游戏介绍内容
	public static final String GAME_INFO_URL = "/api/web/getgameinfo";
	// 普通用户冻结 解冻
	public static final String USER_STATE_UPDATE_URL = "/apis/user/update_status";
}
