// 响应式导航栏按钮
$('.menu.toggle').click(function (){
    $('.m-item').toggleClass('m-mobile-hide');
});

// -----------------博客详情页-------------
// 赞赏二维码
$('#payButton').popup({
    popup: $('.payQR.popup'),
    on: 'click',
    position: 'bottom center'
});



// 目录初始化
tocbot.init({
// Where to render the table of contents.
tocSelector: '.js-toc',
// Where to grab the headings to build the table of contents.
contentSelector: '.js-toc-content',
// Which headings to grab inside of the contentSelector element.
headingSelector: 'h1, h2, h3',
// For headings inside relative or absolute positioned containers within content.
hasInnerContainers: true,
});

// 目录弹出
$('.toc.button').popup({
    popup: $('.toc-container'),
    on: 'click',
    position: 'bottom center'
});

// 二维码生成
var qrcode = new QRCode("qrcode", {
    text: "http://jindo.dev.naver.com/collie",
    width: 110,
    height: 110,
    colorDark : "#000000",
    colorLight : "#ffffff",
    correctLevel : QRCode.CorrectLevel.H
});

// 返回顶部
$('#toTop-button').click(function(){
    $(window).scrollTo(0, 500);
});

// 目录自动出现和消失
var waypoint = new Waypoint({
    element: document.getElementById('waypoint'),
    handler: function(direction) {
        if (direction == 'down') {
            $('#toolbar').show(100);
        }else {
            $('#toolbar').hide(500);
        }
    }
})

// ---------------博客管理页-------------
// 账户注销
$('.ui.dropdown').dropdown({
    on: 'hover'
});

// -----------------博客编辑页------------
// Markdown编辑框初始化
var contentEditor;
$(function() {
    contentEditor = editormd("md-content", {
        width   : "100%",
        height  : 640,
        syncScrolling : "single",
        path    : "../static/lib/editormd/lib/"
    });
});



// 表单验证
$('.ui.form').form({
    fields: {
        title: {
            identifier: 'title',
            rules: [{
                type: 'empty',
                prompt: '标题：请输入博客标题'
            }]
        }
    }
});

// ---------------关于我页---------------
// 弹出微信
$('.wechat').popup({
    popup: $('.wechat-qr'),
    on: 'click',
    position: 'bottom center'
});

// 弹出QQ
$('.qq').popup({
    on: 'click',
    position: 'bottom center'
});