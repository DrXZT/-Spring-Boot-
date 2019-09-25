package com.ptg.formwork.config;//package com.ptg.formwork.config;
//
//
//import com.ptg.formwork.interceptor.LoginInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.List;
//
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurationSupport {
//
//
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//
//
//    // 这个方法是用来配置静态资源的，比如html，js，css，等等
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")//表示拦截所有的请求，
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**","/v2/**", "/swagger-ui.html/**","/doc.html/**","/civa-teach-cloud/user/login/**","/civa-teach-cloud/admin/login/**");//放行swagger,登录
//    }
//
//    // 自定义用户解析类
//    @Override
//    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        super.addArgumentResolvers(argumentResolvers);
//
//    }
//}
