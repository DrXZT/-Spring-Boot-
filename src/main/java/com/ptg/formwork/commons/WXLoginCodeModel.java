package com.ptg.formwork.commons;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * className WXLoginCodeModel
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2018/12/13 16:11
 */
@ToString
@Getter
@Setter
public class WXLoginCodeModel {
    private String session_key;
    private String openid;


}
