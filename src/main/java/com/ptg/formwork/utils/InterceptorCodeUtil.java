package com.ptg.formwork.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Description: 设置拦截器返回信息的工具类
 * User: yangchen
 * Date: Created in  2019/4/26 20:55
 */
public class InterceptorCodeUtil {

    /**
     *
     * @param response
     * @param code
     * @param description
     * @throws Exception
     */
    public static void setResponseCode(HttpServletResponse response, String code, String description) throws Exception {
        PrintWriter writer = null;
        try {
            response.setContentType("text/html; charset=utf-8");
            writer = response.getWriter();
            JSONObject codeJson = new JSONObject();
            codeJson.put("isSuccess", false);
            codeJson.put("code", code);
            codeJson.put("description", description);
            codeJson.put("result", new JSONObject());
            codeJson.put("encrypt", false);
            writer.print(codeJson.toString());
        } catch (Exception e) {
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
        response.flushBuffer();
    }
}
