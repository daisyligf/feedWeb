var setSbUrl = "/laizhubiao/index.php/Index/Order/img_upload";//上传商标地址
var setZzUrl = "/laizhubiao/index.php/Index/Order/img_upload";//发送执照地址
var ajaxMethed="json";

var USE_LOCAL_DATA = 0;//本地数据
    var USE_TEST_DATA = 1;//测试数据

if(USE_LOCAL_DATA){
    setSbUrl="/lzb/data/test/getImg.json";
    setZzUrl="/lzb/data/test/getImg.json";
}
if(USE_TEST_DATA){
    setSbUrl="";
    setZzUrl="";
}

// 图片上传demo1
jQuery(function() {
    var $ = jQuery,
        $list = $('#sbtImgSb-thnumbnail'),
        // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,


        // 缩略图大小
        thumbnailWidth = 205 * ratio,
        thumbnailHeight = 205 * ratio,

        // Web Uploader实例
        uploader;
    // 初始化Web Uploader
    uploader = WebUploader.create({

        // 自动上传。
        auto: true,

        // swf文件路径
        swf: '/lzb/statics/js/lib/uploadImg/Uploader.swf',

        // 文件接收服务端。
        server: setSbUrl,

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#sbtImgSb',

        // 只允许选择文件，可选。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },
        fileVal: "uploadImg-logo"
    });

    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                '</div>'
                ),
            $img = $li.find('img');

        $list.html( $li );

        // 创建缩略图
        uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, thumbnailWidth, thumbnailHeight );
    });

    // 文件上传过程中创建进度条实时显示。
   /* uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<p class="progress"><span></span></p>')
                    .appendTo( $li )
                    .find('span');
        }

        $percent.css( 'width', percentage * 100 + '%' );
    });*/

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on( 'uploadSuccess', function( file,res ) {
        if(res && !res.code){
            $('#logo').val(res.url);
            $('#sbtImgSb').parent().next(".Validedate_check").html('<s class="ok-icon"></s>');
        }
        
    });

    // 文件上传失败，现实上传出错。
    uploader.on( 'uploadError', function( file,res ) {
        
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    /*uploader.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });*/

// 图片上传demo2

    var $list1 = $('#sbtImgZz-thnumbnail'),
        // 优化retina, 在retina下这个值是2
        ratio1 = window.devicePixelRatio || 1,

        // 缩略图大小
        thumbnailWidth1 = 205 * ratio1,
        thumbnailHeight1 = 205 * ratio1,

        // Web Uploader实例
        uploader1;

    // 初始化Web Uploader
    uploader1 = WebUploader.create({

        // 自动上传。
        auto: true,

        // swf文件路径
        swf: '/lzb/statics/js/lib/uploadImg/Uploader.swf',

        // 文件接收服务端。
        server: setZzUrl,

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#sbtImgZz',

        // 只允许选择文件，可选。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },
        fileVal: "uploadImg-license"
    });

    // 当有文件添加进来的时候
    uploader1.on( 'fileQueued', function( file ) {
        var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                '</div>'
                ),
            $img = $li.find('img');

        $list1.html( $li );

        // 创建缩略图
        uploader1.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, thumbnailWidth1, thumbnailHeight1 );
    });

    // 文件上传过程中创建进度条实时显示。
   /* uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<p class="progress"><span></span></p>')
                    .appendTo( $li )
                    .find('span');
        }

        $percent.css( 'width', percentage * 100 + '%' );
    });*/

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader1.on( 'uploadSuccess', function( file,res ) {
        if(res && !res.code){
            $('#license').val(res.url);
            $('#sbtImgZz').parent().next(".Validedate_check").html('<s class="ok-icon"></s>');
        }
    });

    // 文件上传失败，现实上传出错。
    uploader1.on( 'uploadError', function( file,res ) {
        
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    /*uploader.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });*/
});