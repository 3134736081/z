package com.example.demo.iterator;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//component n. 组成; 部件最常考 组成部分常用释义
@Component
//iterator n. 迭代器；迭代程序
//implements v. 执行 v. 实施; 使生效
//handler n. 处理者；管理者 经理人常用释义
//interceptor n. 拦截机；妨碍者；截击机；拦截者，拦截器
public class MyIterator implements HandlerInterceptor {

    @Override
    //pre prep. 在……之前
    //handle n. 柄,把手,拉手 最常 v. 处理,对待,操纵;触,抚养
//    Pick it up by the handle!
//    抓着手柄把它提起来！
    //servlet n. （尤指 Java 语言中在服务器上运行的）小型应用程序；小服务程序
    //拦截器一直处于开着的状态，有个关闭按钮，当你按下假关闭按钮，拦截器还是一直开着，当你按下真关闭按钮，拦截器就关闭了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("此山是我开，此树是我栽，要想从此过，留下买路财");
        return true;
    }

    @Override
    //post n. (网上发)帖子 prefix. 在...之后
//    Have you opened your post yet?
//    你拆开邮件了没有？
    //view v. 看法; 观点; 思考; 考虑 v. 认为; 看待; 视为
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("再见");
    }

    @Override
    //after adj. 在…之后 phr. (after all)毕竟
    //completion n. 完成
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("我们给你留下了好多吃的...........");
    }
}
