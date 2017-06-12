//模块目录
var base =  "";

seajs.config({
    /*base: "./statics/js",*/
    alias: {
        'jquery': '/feedweb/static/feedweb/js/lib/jquery.js',
        'jquery/jquery-validate':"/feedweb/static/feedweb/js/lib/jquery.validate.js",//表单验证插件
        'jquery/jquery-form':"/feedweb/static/feedweb/js/lib/jquery.form.js",//表单验证插件
        'jquery/jquery-singleuploadimage':"/feedweb/static/feedweb/js/lib/jquery.singleuploadimage.js",//图片上传验证
        'jquery/jquery-bxslider':"/feedweb/static/feedweb/js/lib/jquery.bxslider.js",//兼容移动端，pc的选项卡切换
        'jquery/jquery-pagebar':"/feedweb/static/feedweb/js/lib/jquery.pagebar.1.0.0.js",//分页插件
        'handlebars': "/feedweb/static/feedweb/js/lib/handlebars.js",//模板引擎
        'swipe':"/feedweb/static/feedweb/js/lib/swipe.js", //移动端滑动
        'swiper':"/feedweb/static/feedweb/js/lib/swiper.js",//移动端滑块（比上一个强大）
        'jquery/jquery-pop': "/feedweb/static/feedweb/js/lib/mfe/jquery.pop.js", //弹出框组件
        'jquery/moveTop': "/feedweb/static/feedweb/js/lib/mfe/jquery.movetop.js", //回到顶部
        'pagevisibility':"/feedweb/static/feedweb/js/lib/mfe/pagevisibility.js"//检测当前页面是否显示
    },
    paths: {
        'mod':  base + 'mod'
    },
    debug:true

});
