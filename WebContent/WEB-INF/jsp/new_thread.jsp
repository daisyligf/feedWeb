<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>bbs发帖页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/post.css">
    <script src="js/sea.js"></script>
    <script src="js/sea-config.js"></script>


    <!--{* IE6 png 图像处理 *}-->
    <!--[if IE 6]>
        <script src="js/loader/dd_belatedpng.js"></script>
        <script>
            DD_belatedPNG.fix('.pngfix');
        </script>
    <![endif]-->


    <!--{* ie8 以下浏览器html5兼容层 *}-->
    <!--[if lt IE 9]>
        <script src="js/loader/html5shiv.js"></script>
    <![endif]-->
   
    <link rel="stylesheet" href="js/editor/css/umeditor.css">
    <link rel="stylesheet" href="js/editor/css/fixeditor.css">
    <link rel="stylesheet" href="js/editor/emotion.css">
    <script src="js/editor/js/jquery.min.js"></script>
    <script src="js/editor/js/umeditor.config.js"></script>
    <script src="js/editor/js/umeditor.js"></script>
    <script src="js/editor/lang/zh-cn/zh-cn.js"></script>
    <script src="js/editor/btn.js"></script>
    <script src="js/editor/feed-emotion.js"></script>
    <script src="js/editor/comment.js"></script>
    
</head>
<body>
    <div class="page">
        <!-- 头部开始 -->
        <div class="header clearfix">
            <div class="nav clearfix">
                <div class="nav-left">
                    <a href="http://www.mofang.com">魔方网首页</a>
                </div>
                <div class="nav-right">
                    <!-- 登陆状态 -->
                    <!-- <a href="#" class="head"><img src="statics/img/img1.jpg" alt="">蛋碎先生<s class="icon-red"></s></a>
                    <div class="user-info">
                        <ul class="clearfix">
                            <li class="header-money"><s class="icon-money"></s>34356</li>
                            <li class="zuji"><a href="#">足迹</a><a href="#" class="msg">消息<s class="icon-red"></s></a><a href="#" class="libao">礼包库</a></li>
                            <li class="info">
                               <a href="#">个人信息</a><a href="#">设置</a><a href="#" class="out">退出</a> 
                            </li>
                        </ul>
                    </div> -->
                    <!-- 登陆状态 -->
                    <a href="#" class="load"><img src="statics/img/icon/load.png"></a>
                </div>
            </div>
            <div class="nav-wap clearfix">
              <div class="nav-wap-left">
                  <a href="http://www.mofang.com"><img src="statics/img/icon/nav_three.png"></a>
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
            <div class="col-xs-3 user-info-out">
                <div class="user-info">
                   <dl>
                        <dt><a href="#"><img src="statics/img/img1.jpg" alt=""></a></dt>
                        <dd><a href='#'>带你装逼带你飞</a></dd>
                        <dd class="money"><s class="icon-money"></s>235427</dd>
                    </dl>
                    <ul class="clearfix">
                        <li class="col-xs-4"><span>20</span>帖子</li>
                        <li class="col-xs-4"><span>220</span>回复</li>
                        <li class="col-xs-4 no-line"><span>10</span>精华</li>
                    </ul> 
                </div>
                
            </div>
            <div class="col-xs-9 col-md-12 post">
                <h2>发新帖</h2>
                <div class="title-type clearfix">
                    <input type="text" class="col-xs-10 title" placeholder="帖子标题">
                    <div class="col-xs-2">
                        <div class="sel">
                            <a class="sel-defa">
                                综合
                            </a>
                        </div>
                    </div>
                </div>
                <div class="editer">
                    <div class="editor-textarea">
                    </div>
                    <script type="text/plain" id="myEditor" style="height:240px;">{$post.content}</script>

                    <!-- <textarea name="" id="" class="textarea" cols="30" rows="10"></textarea> -->
                </div>
                <div class="sub clearfix">
                    <input type="text" class="code-text">
                    <img src="statics/img/img1.jpg" alt="" class="code">
                    <input type="submit" class="submit" value="发表帖子">
                </div>
            </div>
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
    </div>
    <script>
        seajs.use("comment");
    </script>
   <script src="js/mod/index.js"></script>
   
</body>
</html>
