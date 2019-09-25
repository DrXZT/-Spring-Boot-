package com.ptg.formwork.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @Desc  DTO基类
 * @Author ： DR XZT
 * @Date ：Created in 2018/9/14 9:21
 */
@Data
@NoArgsConstructor
public class BaseDTO implements Serializable {
    @ApiModelProperty(value = "用户ID", hidden = true)
    private String userId;
    @ApiModelProperty(value = "systemId")
    private String systemId;

    /**
     * 这个方法会在使用打印的时候  输出toString方法  子类不用复写 ToString()方法
     * @return
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
