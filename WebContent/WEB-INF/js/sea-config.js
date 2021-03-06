//模块目录
var base =  "";

seajs.config({
    /*base: "./statics/js",*/
    alias: {
        'jquery': 'lib/jquery.js',
        'jquery/jquery-validate':"lib/jquery.validate.js",//表单验证插件
        'jquery/jquery-form':"lib/jquery.form.js",//表单验证插件
        'jquery/jquery-singleuploadimage':"lib/jquery.singleuploadimage.js",//图片上传验证
        'jquery/jquery-bxslider':"lib/jquery.bxslider.js",//兼容移动端，pc的选项卡切换
        'jquery/jquery-pagebar':"lib/jquery.pagebar.1.0.0.js",//分页插件
        'handlebars': "lib/handlebars.js",//模板引擎
        'swipe':"lib/swipe.js", //移动端滑动
        'swiper':"lib/swiper.js",//移动端滑块（比上一个强大）
        'jquery/jquery-pop': "lib/mfe/jquery.pop.js", //弹出框组件
        'jquery/moveTop': "lib/mfe/jquery.movetop.js", //回到顶部
        'pagevisibility':"lib/mfe/pagevisibility.js"//检测当前页面是否显示
    },
    paths: {
        'mod':  base + 'mod'
    },
    debug:true

});
