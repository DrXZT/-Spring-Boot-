package com.ptg.formwork.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * Web层面的工具类.
 *
 * @author ligj
 */
public final class WebHelper {

    private WebHelper() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * 获得用户远程地址
     *
     * @param request the request
     * @return the remote addr
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }

    /**
     * 获取访问路径
     *
     * @param request HttpServletRequest
     * @return 访问路径 base url
     */
    public static String getBaseURL(HttpServletRequest request) {
        String path = request.getContextPath();
        return request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

}