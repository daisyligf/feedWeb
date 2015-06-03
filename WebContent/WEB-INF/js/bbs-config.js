//模块目录
var base =  "";

seajs.config({
    alias: {
        'login_top': 'mod/login_top.js'//登录状态

    },
    paths: {
        'mod':  base + 'mod'
    },
    debug:false

});
