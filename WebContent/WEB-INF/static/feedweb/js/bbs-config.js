//模块目录
var base =  "";

seajs.config({
    alias: {
        'login_top': '/feedweb/static/feedweb/js/mod/login_top.js',//登录状态
        'config' : '/feedweb/static/feedweb/js/mod/config.js',//配置文件
        'loginUserUrl' : '/feedweb/static/feedweb/js/mod/loginUserUrl.js',//跳转登录路径
        'ad' : '/feedweb/static/feedweb/js/mod/ad.js'//广告位

    },
    paths: {
        'mod':  base + 'mod'
    },
    debug:false

});
