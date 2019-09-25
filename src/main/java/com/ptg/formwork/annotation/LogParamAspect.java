package com.ptg.formwork.annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ptg.formwork.base.BaseDTO;
import com.ptg.formwork.utils.WebHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @文件名: web请求消息日志统一处理
 * @包名 com.ccw.service.student.rest.api.annotation
 * @描述:
 * @创建者 linwq
 * @创建时间 2019-05-27 10:52
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class LogParamAspect {

    /**
     * logger类
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义一个切入点.
     * 第一个 * 代表任意修饰符及任意返回值.
     * 第二个 * 定义在controller包或者子包
     * 第三个 * 任意方法
     *  .. 匹配任意数量的参数.
     */
    @Pointcut(value = "execution(public * com.ptg.formwork.controller..*.*(..))")
    public void webLog(){}


    @Before(value="webLog()")
    public void doBefore(JoinPoint joinPoint){
        if(logger.isDebugEnabled()) {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String url = request.getRequestURI();

            String[] params = ((CodeSignature) joinPoint.getStaticPart().getSignature()).getParameterNames();

            //参数
            Object[] args = joinPoint.getArgs();

            StringBuffer strBuffer = new StringBuffer();
            strBuffer.append("IP:").append(WebHelper.getRemoteAddr(request));
            strBuffer.append(",接口：").append(url).append(", 入参:");
            if (args.length==0){
                strBuffer.append("{}");
            }
            for (int i = 0; i < args.length; i ++) {
                if (args[i] instanceof BaseDTO) {
                    strBuffer.append(params[i]).append("=").append(JSONObject.parseObject(JSON.toJSONString(args[i])));
                } else {
                    strBuffer.append(params[i]).append("=").append(args[i]);
                }

                if(i != args.length - 1) {
                    strBuffer.append(",");
                }
            }

            logger.debug(strBuffer.toString());
        }
    }

}
