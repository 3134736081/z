package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//configuration n. 配置; 布局; 构造常考词
//configurer 配置器常用释义
public class SpringConfiguration implements WebMvcConfigurer {

    @Autowired
    @Qualifier("myIterator")
    private HandlerInterceptor myHandlerInterceptor;

    @Autowired
    @Qualifier("loginIterator")
    private HandlerInterceptor loginHandlerInterceptor;

    @Override
    //registry n. 注册；登记处；挂号处；船舶的国籍
//    It belongs to an asset registry.
//    它属于一个资产/注册表/。
    public void addInterceptors(InterceptorRegistry registry) {
        //patterns n. (形成)模式; 方式v. 图案; 加上花样
        registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/**") // /**也对
                //exclude v. 排除在外; 不予考虑
                .excludePathPatterns("/user/index");

        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/index");
//        registry.addInterceptor(loginHandlerInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/login",          // 放行登录请求
//                        "/static/**",     // 放行静态资源
//                        "/error"          // 放行错误页面
//                );
    }
}
