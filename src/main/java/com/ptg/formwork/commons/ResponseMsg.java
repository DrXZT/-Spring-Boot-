package com.ptg.formwork.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * className: ResponseMsg
 * description: TODO
 *
 * @author hasee
 * @version 1.0
 * @date 2019/2/10 17:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMsg implements Serializable {
    private static final long serialVersionUID = -3542357415146381433L;
    public static final Integer SUCCESS = 1;
    public static final Integer FAILED = 0;
    private String msg;
    @NonNull
    private int code = -1;
    private Object data;

    public static long getSerialversionuid() {
        return -3542357415146381433L;
    }

    public static ResponseMsg sendError(int code, String msg) {
        ResponseMsg message = new ResponseMsg();
        message.setCode(code);
        message.setMsg(msg);
        message.setData(null);
        return message;
    }

    public static ResponseMsg sendSuccess(Object data) {
        ResponseMsg message = new ResponseMsg();
        message.setCode(SUCCESS);
        message.setMsg("成功");
        message.setData(data);
        return message;
    }
}
