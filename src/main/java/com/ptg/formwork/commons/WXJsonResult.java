package com.ptg.formwork.commons;

/**
 * className WXJsonResult
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2018/12/13 17:24
 */

public class WXJsonResult {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok;    // 不使用

    public static WXJsonResult build(Integer status, String msg, Object data) {
        return new WXJsonResult(status, msg, data);
    }

    public static WXJsonResult ok(Object data) {
        return new WXJsonResult(data);
    }

    public static WXJsonResult ok() {
        return new WXJsonResult(null);
    }

    public static WXJsonResult errorMsg(String msg) {
        return new WXJsonResult(500, msg, null);
    }

    public static WXJsonResult errorMap(Object data) {
        return new WXJsonResult(501, "error", data);
    }

    public static WXJsonResult errorTokenMsg(String msg) {
        return new WXJsonResult(502, msg, null);
    }

    public static WXJsonResult errorException(String msg) {
        return new WXJsonResult(555, msg, null);
    }

    public WXJsonResult() {

    }

    public WXJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public WXJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
