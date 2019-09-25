package com.ptg.formwork.commons;

import com.ptg.formwork.enums.EnumMsgCode;

/**
 * className MyException
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/8/19 11:03
 */

public class MyException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1184306942479888629L;

    public MyException(EnumMsgCode msgCode) {
        if ( msgCode == null ) {
            this.code = EnumMsgCode.MSG_SYS_ERROR.getCode();
            this.msg = EnumMsgCode.MSG_SYS_ERROR.getDescription();
        }
        else {
            this.code = msgCode.getCode();
            this.msg = msgCode.getDescription();
        }
    }

    private String code;
    private String msg;

    public MyException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg) {
        super(msg);
        this.code = EnumMsgCode.MSG_BIZ_ERROR.getCode();
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
