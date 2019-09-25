package com.ptg.formwork.enums;



import org.apache.commons.lang.StringUtils;

import java.text.MessageFormat;

/**
 * className EnumMsgCode
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/8/19 11:05
 */

public enum EnumMsgCode {
    //公用提示
    MSG_BIZ_ERROR("1314", "业务数据异常"),
    MSG_SYS_ERROR("9999", "系统异常，请稍后再试~"),
    MSG_SUCCESS("0000", "请求成功"),
    MSG_0000("0000", "请求成功"),
    MSG_0005("0005", "参数不全"),
    //用户异常
    MSG_8000("8000", "登录失败,用户不存在"),
    MSG_8001("8001", "登录失败,密码错误"),
    MSG_8002("8002", "验证码不正确或已超时"),
    MSG_8003("8003", "该手机已注册，请勿重复注册"),
    MSG_LOGIN_1017("1017", "登录时间超时 请重新登录!"),
    MSG_LOGIN_1024("1024", "您的账号已在另一台设备登录！"),
    MSG_LOGIN_1025("1025", "请先登录账号！");
    private String code;

    private String description;

    EnumMsgCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public static EnumMsgCode getByKey(String code) {
        if (StringUtils.isBlank(code)) {
            return null;

        }
        for (EnumMsgCode type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static String getMessage(EnumMsgCode code, Object... arguments) {
        if (code == null) {
            return null;
        }
        return MessageFormat.format(code.getDescription(), arguments);
    }


    public static boolean isSuccess(EnumMsgCode code) {
        if (code == MSG_0000) {
            return true;
        }
        return false;
    }
}
