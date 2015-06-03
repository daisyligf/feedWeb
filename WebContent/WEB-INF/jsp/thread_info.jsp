<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--{* 使用IE最高版本渲染,如果有chrome frome插件,则使用chrome frame *}-->

    <!--[if !IE]><!-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--<![endif]-->

    <!--{* 让360浏览器默认以chrome内核显示 *}-->
    <meta name="renderer" content="webkit">

    <!-- 移动端处理 -->
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <!--  phone numer select -->
    <meta name="format-detection" content="telephone=no" />
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>bbs帖子页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="css/base.css">

    <link rel="stylesheet" href="js/editor/css/umeditor.css">
    <link rel="stylesheet" href="js/editor/css/fixeditor.css">
    <link rel="stylesheet" href="js/editor/emotion.css">

    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/article_article.css">
    <script src="js/sea.js"></script>
    <script src="js/sea-config.js"></script>
    <script src="js/bbs-config.js"></script>

    
    <script src="js/editor/js/jquery.min.js"></script>
    <script src="js/editor/js/umeditor.config.js"></script>
    <script src="js/editor/js/umeditor.js"></script>
    <script src="js/editor/lang/zh-cn/zh-cn.js"></script>
    <script src="js/editor/btn.js"></script>
    <script src="js/editor/feed-emotion.js"></script>
    
    <!--{* IE6 png 图像处理 *}-->
    <!--[if IE 6]>
        <script src="./statics/js/loader/dd_belatedpng.js"></script>
        <script>
            DD_belatedPNG.fix('.pngfix');
        </script>
    <![endif]-->


    <!--{* ie8 以下浏览器html5兼容层 *}-->
    <!--[if lt IE 9]>
        <script src="./statics/js/loader/html5shiv.js"></script>
    <![endif]-->
    
</head>
<body>
    <div class="page">
        <!-- 头部开始 -->
        <div class="header clearfix">
            <div class="nav clearfix">
                <div class="nav-left">
                    <a href="http://www.mofang.com">魔方网首页</a>
                </div>
                <div class="nav-right" id="topUserInfo">
                    <!-- 登陆状态 -->
                    <!-- top登录模板 -->
                    
                    <a href="http://u.mofang.com/home/person/index" class="head" id="userName"><img src="" alt="" id="userImg" /><!-- <s class="icon-red"></s> --></a>
                    <div class="user-info">
                        <ul class="clearfix">
                            <li class="header-money" id="userMoney"><s class="icon-money"></s></li>
                            <li class="zuji"><a href="http://u.mofang.com/home/footprints/games">足迹</a><a href="http://u.mofang.com/home/message/reply" class="msg">消息<s class="icon-red"></s></a><a href="http://u.mofang.com/home/package/index" class="libao">礼包库</a></li>
                            <li class="info">
                               <a href="http://u.mofang.com/home/person/index">个人信息</a><a href="http://u.mofang.com/home/setting/info">设置</a><a href="javascript:;" class="out" id="logout">退出</a> 
                            </li>
                        </ul>
                    </div>
                    
                    <!-- 登陆状态 -->
                    <a href="http://u.mofang.com/home/account/index" class="load" target="_blank"><img src="img/icon/load.png"></a>
                </div>
            </div>
            <div class="nav-wap clearfix">
              <div class="nav-wap-left">
                  <a href="http://www.mofang.com"><img src="img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a class="nav-info-home">首页</a>
                    <a>个人中心</a>
                  </p>
              </div> 
            </div>
        </div>
        <!-- 头部结束 -->
        
        <!-- 内容开始 -->
        <div class="con clearfix">
            <div class="nav clearfix">
                <div class="nav-left">
                    <a href="#">论坛首页</a> > <a href="#">乱斗西游</a> > <a href="javascript:;" class="end">舌尖上西游</a>
                </div>
                <div class="page-plug">
                    <ul class="page-pc">
                        <li class="prev"><a href="#">上一页</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li class="active"><a href="javascript:;">3</a></li>
                        <li><a href="#">4</a></li>
                        <li class="next"><a href="#">下一页</a></li>
                    </ul>
                    <ul class="page-mobile">
                        <li class="prev"><a href="#">上一页</a></li>
                        <li class="text">5/235</li>
                        <li class="next"><a href="#">下一页</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-3 user-info-out">
                <div class="user-info">
                   <dl>
                        <dt><a href="#"><img src="img/img1.jpg" alt=""></a></dt>
                        <dd><a href='#'>带你装逼带你飞</a></dd>
                        <dd class="money"><s class="icon-money"></s>235427</dd>
                    </dl>
                    <ul class="clearfix">
                        <li class="col-xs-4"><span>20</span>帖子</li>
                        <li class="col-xs-4"><span>220</span>回复</li>
                        <li class="col-xs-4 no-line"><span>10</span>精华</li>
                    </ul> 
                </div>
                <div class="lord-team">
                    <h2 class="lum">
                        最热推荐
                    </h2>
                    <div class="lum-list libao-list">
                       <ul>
                           <li><s class="black"></s><a href="#">我是大礼包</a></li>
                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
                       </ul>
                    </div>
                    
                </div>
            </div>
            <div class="col-xs-9 col-md-12" id="getPostData" data-tid="23245" data-uid="23412" data-fid="">
                <div class="con-right1 clearfix">
                    <dl class="con-author clearfix">
                        <dt class="author-img">
                            <img src="img/img1.jpg" alt="">
                        </dt>
                        <dd class="author-name">但岁先生</dd>
                        <dd class="author-detail"><b>楼主</b><span>05-14</span><span> 15:10</span></dd>
                    </dl>
                    <h2>《最终幻想14》2.2新版截图推出炫耀装备系统 
                        <a href="#" class="landord">只看楼主</a>
                        <div class="manage">帖子管理
                            <div class="manage-more clearfix">
                                <a href="#" class="manege-top">置顶</a>
                                <a href="#" class="manege-great">精华</a>
                                <a href="#" class="manage-lock">锁帖</a>
                            </div>
                        </div>
                        
                    </h2>
                    <h3>楼主  <a href="#">张无忌打太极</a>  发表于  5-18  12:12</h3>
                    <div class="con-con">
                        <p>游戏在操作上，融合了塔防的常规操作，但又和一般闯关游戏有着截然不同的操作。在 闯关任务中，玩家不再是依靠虚拟摇杆以及虚拟按键，而采用了随机划线的方式，可以根据自己设计的路线，规划出机器人的行 走路线。而且路线不单单是走直角或转直角，斜角路线的加入，让游戏更加具有可玩性外，还非常的人性化。</p>
                        <img src="img/img3.jpg" height="336" width="448" alt="">
                    </div>
                    <p class="look">
                        <span class="zan"><s class="icon-zan"></s><a href="javascript:;">3425</a></span>
                        <span><a href="#conRight2"><s class="icon-ask"></s>325</a></span>
                    </p>
                </div>
                <div class="con-right2" id="conRight2">
                    <!-- 楼层回复模板1 -->
                    <script id="floorCommentTemplate" type="text/x-handlebars-template">
                        {{#each this}}
                        <dl class="clearfix">
                            <dt><a href="{{url}}"><img src="{{avatar}}" alt=""></a></dt>
                            <dd><a href="{{url}}">{{nickname}}:</a>&nbsp;&nbsp;&nbsp; {{content}}</dd>
                            <dd class="autor">{{timeformat ctime}}        <a href="javascript:;" class="dianping" data-name="{{nickname}}" data-uid="{{uid}}" data-tid="{{tid}}">回复</a></dd>
                        </dl>
                        {{/each}} 
                    </script>
                    <!-- 楼层回复模板2 -->
                    <script id="floorCommentTemplate2" type="text/x-handlebars-template">
                        
                        <dl class="clearfix">
                            <dt><a href="{{url}}"><img src="{{avatar}}" alt=""></a></dt>
                            <dd><a href="{{url}}">{{nickname}}:</a>&nbsp;&nbsp;&nbsp; {{content}}</dd>
                            <dd class="autor">{{timeformat ctime}}        <a href="javascript:;" class="dianping" data-name="{{nickname}}" data-uid="{{uid}}" data-tid="{{tid}}">回复</a></dd>
                        </dl>
                    </script>
                    
                    <div class="con-list" data-postid="123214" data-uid="1234" data-page='1'>
                        <p class="con-list-left">
                            <img src="img/img1.jpg" alt="">
                        </p>
                        <div class="con-list-right">
                            <dl class="list-right-dl">
                                <dt><a href="javascript:;" class="list-del">删除</a>2楼  <a href="#">腰里别块砖</a>    发表于  5-18  12:12</dt>
                                <dd>主打变形格斗的次时代科幻热血格斗手游，游戏以未来世界人类陷入虚拟游戏的囚禁、为挣脱枷锁全力战斗为背景，给玩家们展示了一个充满变异物种岌岌可危的世界。</dd>
                                <dd class="clearfix">
                                    <p class="look">
                                        <span class="zan"><s class="icon-zan"></s><a href="javascript:;">3425</a></span><span class="floor-stop"><s class="icon-ask reply-hide"></s>收起</span><span class="floor-rec"><s class="icon-ask"></s><a href="javascript:;">3425</a></span>
                                    </p>
                                </dd>
                            </dl>
                            <div class="con-list-reply">
                                <div class="con-list-replycon">
                                    <!--楼层回复内容-->
                                </div>
                                
                                <p class="floor-reply-more">更多128条回复    <a href="javascript:;">点击加载</a></p>
                                <div class="reply-textarea">
                                    <input type="hidden"  name="tid" class="tid" value="2342"/>
                                    <input type="hidden"  name="uid" class="uid" value="2342"/>
                                    <input type="hidden"  name="postname" class="postname" value="2342"/>
                                    <textarea name="" class="dianping-textarea" cols="30" rows="10">回复</textarea>
                                    <p class="replay-floor">还可以输入140字 <input type="button" class="reply-btn" value="回复"></p>
                                </div>
                            </div>
                            
                        </div>
                       
                    </div>
                    <!-- 分页 -->
                    <div class="page-plug">
                        
                        <ul class="page-mobile clearfix">
                            <li class="prev"><a href="#">上一页</a></li>
                            <li class="text">5/235</li>
                            <li class="next"><a href="#">下一页</a></li>
                        </ul>
                    </div>

                </div>
                <div class="con-right3 reply-textarea">
                    <div class="reply-textarea-info clearfix">
                        <p class="reply-head"><a href="#"><img src="img/img1.jpg" alt=""></a></p>
                        <dl>
                            <dt></dt>
                            <dd><textarea name="" id="" cols="30" rows="10" class="editor-cont"></textarea></dd>
                            <dd>
                                <div class="editer">
                                    <div class="editor-textarea">
                                        <div class="textmask">您需要登录后才可以发帖 <a class="maskLogin" href="http://u.mofang.com/">登录</a> | <a  class="maskReg" href="http://u.mofang.com/">立即注册</a></div>
                                    </div>
                                    <script type="text/plain" id="myEditor" style="height:240px;">您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发您需要登录后才可以发</script>
                                </div>
                            </dd>
                        </dl>
                    </div>
                    
                    <p class="replay-floor">还可以输入10000字 <input type="button" class="reply-editer reply-submit" value="回复"></p>
                </div>
            </div>
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
        <!-- 弹出框开始 -->
        <!-- 遮罩层开始 -->
        <div class="mask-bg">
            
        </div>
        <!-- 遮罩层结束 -->
        
        <div class="pop pop-post-delete">
            <h2 class="clearfix">
                <span>
                    <img src="img/icon/pop_close.png" class="close">
                </span>删除帖子
            </h2>
            <div class="post-delete-reason">
                <p  class="post-delete-sure pop-title">确定要删除帖子？</p>
                <form action="">
                    <div class="delete-reason-choose pop-msg-title">选择原因</div>
    
                    <textarea name="" class="pop-msg"></textarea>
                    <p class="delete-reason-but clearfix">
                        <input type="button" class="delete-reason-cancel pop-cancel" value="取消">
                        <input type="button" class="delete-reason-ok pop-ok" value="确定">
                    </p>
                </form>
            </div>
        </div>
        <!-- 成功 -->
        <div class="pop pop-post-ok">   
            <img src="img/icon/pop_ok.png"><span class="pop-msg">成功</span>
        </div>
        <!-- 失败 -->
        <div class="pop pop-top-fail">
            <img src="img/icon/pop_fail.png"><span class="pop-msg">失败</span>
        </div>
        <!-- 弹出框结束 -->
    </div>
    
    <script src="js/mod/article_article.js"></script>
    <script src="js/mod/common.js"></script>
    <script src="js/mod/comment.js"></script>
</body>
</html>
