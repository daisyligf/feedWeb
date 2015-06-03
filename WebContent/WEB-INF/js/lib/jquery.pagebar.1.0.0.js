/// <reference path="jquery.js"/>
/*
 * jpagebar
 * version: 1.0.0
 * @ jQuery v1.3.*
 * @xukuikui 改良版的分页插件，适合本项目的插件
 */


define('jquery/jquery-pagebar', ['jquery'], function(require, exports, module) {
	

	var $ = jQuery = require("jquery");

	(function($) {
	    $.extend($.fn, {
	        jpagebar: function(setting) {
	            var pb = $.extend({
	                //pagebar 对象div
	                renderTo: $("body"),
	                //总数
	                totalNum: 0,
	                //总页码
	                totalpage: 0,
	                //当前页码
	                currentPage: 1,
	                //分页条样式
	                pagebarCssName: 'pagebar',
	                //当前选中页码样式
	                currentPageNumberCssName:'current_page_number',
	                //点击页码action
	                onClickPage : function(pageIndex){

	                }
	            }, setting);


	            pb.resetPagebar = function(){
	                var _this = this;
	                _this.renderTo = (typeof _this.renderTo == 'string' ? $(_this.renderTo) : _this.renderTo);

	                /* ---------->
					html :
					<ul class="page-pc">
                        <li class="prev"><a href="#">上一页</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li class="active"><a href="javascript:;">3</a></li>
                        <li><a href="#">4</a></li>
                        <li class="next"><a href="#">下一页</a></li>
                    </ul>
					<-----------*/
	                var pagebar = _this.renderTo;
	                pagebar.attr('class',_this.pagebarCssName);

	                //清空分页导航条
	                pagebar.empty();

	                if(totalpage = 0){
	                    return ;
	                }

	                // 分页
	                var front_block = parseInt(_this.currentPage) - 5;// 当前页码前面一截
	                var back_block = parseInt(_this.currentPage) + 5;// 当前页码后面一截

	                /*$('<span>共</span><span id=“total_count”>'+ _this.totalNum +'</span><span>条</span>')
	                .appendTo(pagebar);*/
	                
	                /*$('<span>&nbsp;&nbsp;</span>')
	                .appendTo(pagebar);*/

	                //处理首页、上一页
	                if(_this.currentPage == 1 ){
	                    //当前页为第一页
	                    /*$('<span>首页</span> ').attr('class',_this.pageNameCssName)
	                    .appendTo(pagebar);*/
	                    /*$(' <li><a href="#">上一页</a></li> ').attr('class',_this.pageNameCssName).appendTo(pagebar);*/

	                }else{
	                    //当前页大于第一页
	                    /*$('<a>首页</a> ').attr('class',_this.pageNameCssName)
	                    .bind("click", function(){
	                        _this.onClickPage(1);
	                    })
	                    .appendTo(pagebar);*/
	                    $('<li class="prev"><a>上一页</a></li>')
	                    .bind("click", function(){
	                        _this.onClickPage(_this.currentPage-1);
	                    })
	                    .appendTo(pagebar);

	                    //移动端上一页
	                    $(".page-mobile .prev").unbind("click").bind("click",function(){
	                    	_this.onClickPage(_this.currentPage-1);
	                    });

	                }

	                //处理数字页码

	                if(_this.totalpage == 1){
	                    //共1页
	                    $('<li><a>1</a></li> ').attr('class',_this.currentPageNumberCssName)
	                    .bind("click", function(){
	                        _this.onClickPage(1);
	                    })
	                    .appendTo(_this.renderTo);

	                }else{
	                    //有多页
	                    var tempBack_block = _this.totalpage;
	                    var tempFront_block = 1;
	                    if (back_block < _this.totalpage)
	                        tempBack_block = back_block;
	                    if (front_block > 1)
	                        tempFront_block = front_block;

	                    for (var i = tempFront_block; i <= tempBack_block; i++) {
	                    	(function(index){
	                    		if (_this.currentPage == index) {
	                            //当前页
		                            $('<li><a>'+index+'</a></li> ').attr('class', _this.currentPageNumberCssName)
		                            .appendTo(pagebar);
		                        } else {
		                            $('<li><a>'+index+'</a></li> ')
		                            .bind("click", function(){
		                                _this.onClickPage(index);
		                            }).appendTo(pagebar);

		                        }
	                    	})(i);
	                        
	                    }
	                }

	                // 下一页, 尾页  处理
	                if (_this.currentPage >= _this.totalpage) {
	                    //当前页为最后一页
	                    /*$('<span>下一页</span> ').attr('class',_this.pageNameCssName)
	                    .appendTo(pagebar);
	                    $('<span>尾页</span> ').attr('class',_this.pageNameCssName)
	                    .appendTo(pagebar);*/
	                } else {
	                    $('<li class="next"><a>下一页</a></li> ')
	                    .bind("click", function(){
	                        _this.onClickPage(parseInt(_this.currentPage)+1);
	                    })
	                    .appendTo(pagebar);
	                    //移动端下一页
	                    $(".page-mobile .next").unbind("click").bind("click",function(){
	                    	_this.onClickPage(_this.currentPage+1);
	                    });
	                }

	               /* $('<li><a>&nbsp;&nbsp;</a></li>')
	                .appendTo(pagebar);*/

	                /*$(' <span id=“total_page”> '+ _this.totalpage +'</span><span>页</span>')
	                .appendTo(pagebar);*/

	                
	                /*$('<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>')
	                .appendTo(pagebar);*/
	                
	                /*$('<span class="page_feed_back">服务器忙，请稍后重试。</span>')
	                .appendTo(pagebar);
	                var lastIndex = window.location.href.indexOf("admin");
	                if(lastIndex!=-1){
	                    var url = window.location.href.substring(0,lastIndex);
	                    var imgSrc = url + "/static/v4/images/common/spin.gif";
	                    $('<span class="page_hint"><img id="img_page_hint" src="'+imgSrc+'" style="vertical-align:middle;"/></span>').appendTo(pagebar);
	                }else{
	                    $('<span class="page_hint"><img id="img_page_hint" src="/static/v4/images/common/spin.gif" style="vertical-align:middle;"/></span>').appendTo(pagebar);
	                }*/
	            }
	            pb.resetPagebar();
	        },
	        setCurrentPage:function(_this,currentPage){
	            _this.currentPage = currentPage;
	            _this.resetPagebar(_this);
	        }

	    });
	})(jQuery);

	if(typeof module!="undefined" && module.exports){
        module.exports = $;
    }

});