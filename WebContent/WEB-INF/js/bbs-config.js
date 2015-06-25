//模块目录
var base =  "";

seajs.config({
    alias: {
        'login_top': 'mod/login_top.js',//登录状态
        'config' : 'mod/config.js',//配置文件
        'loginUserUrl' : 'mod/loginUserUrl.js',//跳转登录路径
        'ad' : 'mod/ad.js'//广告位

    },
    paths: {
        'mod':  base + 'mod'
    },
    debug:false

});
