package com.example.demo.b_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1. 加了 @ResponseBody 则代表将数据放到 响应正文 里面
 * 2. 但如果 响应正文 中只有普通的字符串，浏览器就会帮我们擦屁股，构造成一个网页
 * 3. 因此我们可以自己构造一个完整的页面放到 响应正文 发送给浏览器
 * 4. 接着，如果不加 @ResponseBody 的话，也就是相当于省略了 forward:/
 * 5. 表示受到信之后把信再转交给别人，比如 return "index", 则表示把HTTP请求再移交给 @RequestMapping("/lyx")去处理
 * 6. 那这样的话，如果我们在 "index" 这个收信人上写 return "换一个完整的页面"
 * 7. 以后我们在写信给 "hello" 的时候，我们收到的就是一个完整的页面了，并且只有一行代码；return "index"
 * 8. 那如果在前端和后端中间有一个人来帮我们完成这个中间的工作，我们就可以只专心写后端的内容了，要返回页面的话直接写 return "index" 就行了
 * 9. 接下来，当我们把一个完整的页面放入到 static 里面，然后在 hello 中写上 return "index.html"
 * 9. 再通过浏览器去写信给 "hello" 的时候，我们就能直接收到一个静态页面了，我们会发现，这个中间人已经有了！也就是 Spring MVC帮我们做好了
 * 10. 以后我们要返回的静态页面的时候，直接把页面放入到 static 里面，接着在后端里写 return "静态页面" 就好了
 * 11. 剩下的那些麻烦的工作，比如先写 @RequestMapping("/index"), 接着在 return 里面写完整的页面都是 Spring MVC 帮我们做好的
 * 12. 并且，我们也可以直接在浏览器中输入 127.0.0.1:8080/index.html，这跟我们前面输入 127.0.0.1:8080/hello 是一样的
 * 13. 所以现在我们回头看一下之前在浏览器中打开我们写好的页面的原理是怎样的，就跟上面是一样的，不信的话可以抓个包
 * 14. 这里还有最后一个要学习的东西：重定向
 * 15. 那为什么明明就没有连网，我们也可以通过 HTTP协议 进行通信呢？还可以进行收信和回信呢。。。。。。
 */

@Controller
@ResponseBody
public class A_ResponseBody {
    @RequestMapping("responsebody")
    public String responseBody() {
        return "Hello Spring MVC";
    }
}
