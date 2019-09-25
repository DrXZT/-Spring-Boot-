package com.ptg.formwork.commons;


import com.ptg.formwork.enums.EnumMsgCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang.StringUtils;


import java.util.Date;

/**
 * className RestResponseModel
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/8/19 11:15
 */
@ApiModel(description= "返回响应数据")
@Data
public class RestResponseModel {
    @ApiModelProperty(value = "是否成功")
    private boolean isSuccess;

    @ApiModelProperty(value = "业务结果代码, '0000'表示成功，其它都是业务失败")
    private String code;

    @ApiModelProperty(value = "结果描述")
    private String description;

    @ApiModelProperty(value = "一般是成功时候，返回的业务对象")
    private Object result;

    @ApiModelProperty(value = "是否需要加密")
    private boolean encrypt;

    @ApiModelProperty(value = "系统编号ID")
    private String systemId;

    @ApiModelProperty(value = "系统当前时间")
    private Date systemTime;

    public void setResultInfo(EnumMsgCode code) {
        if ( code == null ) {
            this.code = EnumMsgCode.MSG_SYS_ERROR.getCode();
            this.description = EnumMsgCode.MSG_SYS_ERROR.getDescription();
        }
        else {
            this.code = code.getCode();
            this.description = code.getDescription();
        }
    }

    public void setResultInfo(EnumMsgCode code, String messgae) {
        this.code = code.getCode();
        if(StringUtils.isBlank(messgae)) {
            this.description = code.getDescription();
        } else {
            this.description = messgae;
        }

    }
}
