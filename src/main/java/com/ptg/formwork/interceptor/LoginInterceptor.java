package com.ptg.formwork.interceptor;//package com.ptg.formwork.interceptor;
//
//
//import com.ptg.formwork.annotation.NoLogin;
//import com.ptg.formwork.enums.EnumMsgCode;
//import com.ptg.formwork.utils.InterceptorCodeUtil;
//import com.ptg.formwork.utils.RedisUtil;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * Description: 登录拦截器
// * User: yangchen
// * Date: Created in  2019/4/26 17:13
// */
//
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    //token 名称
//    public static final String AUTHORIZATION = "Authorization";
//
//    protected Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (!(handler instanceof HandlerMethod)) {
//            logger.debug("不是HandlerMethod类型，则无需检查");
//            return true;
//        } else {
//            HandlerMethod method = (HandlerMethod) handler;
//            //判断是否存在该注解
//            boolean hasLoginAnnotation = method.getMethod().isAnnotationPresent(NoLogin.class);
//            if (hasLoginAnnotation) {
//                return true;
//            }
//            String token = request.getHeader(AUTHORIZATION);
//            if (StringUtils.isBlank(token)) {
//                // 没有登录
//                InterceptorCodeUtil.setResponseCode(response, EnumMsgCode.MSG_LOGIN_1025.getCode(), EnumMsgCode.MSG_LOGIN_1025.getDescription());
//                return false;
//            }
//            //验证token
//            String requestTonken;
//            //try {
//            //    requestTonken = AppUtil.decryptStr(token, AppUtil.AES_KEY);
//            //} catch (Exception e) {
//            //    // 登录时间超时 请重新登录
//            //    InterceptorCodeUtil.setResponseCode(response,EnumMsgCode.MSG_LOGIN_1017.getCode(),EnumMsgCode.MSG_LOGIN_1017.getDescription());
//            //    return false;
//            //}
//            //if (requestTonken == null) {
//            //    InterceptorCodeUtil.setResponseCode(response,EnumMsgCode.MSG_LOGIN_1024.getCode(),EnumMsgCode.MSG_LOGIN_1024.getDescription());
//            //    return false;
//            //}
//            // 根据userId 取出redis中的token数据
//            //String[] tonkenArray= requestTonken.split("_");
//            String tokenKey = null;
//
//            String redisToken = redisUtil.get(tokenKey);
//            if (StringUtils.isBlank(redisToken)) {
//                // 登录时间超时 请重新登录
//                InterceptorCodeUtil.setResponseCode(response, EnumMsgCode.MSG_LOGIN_1024.getCode(), EnumMsgCode.MSG_LOGIN_1017.getDescription());
//                return false;
//            }
//            if (!StringUtils.equals(redisToken, token)) {
//                // 在其他设备登录
//                InterceptorCodeUtil.setResponseCode(response, EnumMsgCode.MSG_LOGIN_1024.getCode(), EnumMsgCode.MSG_LOGIN_1024.getDescription());
//                return false;
//            }
//
//        }
//        return true;
//    }
//
//}
