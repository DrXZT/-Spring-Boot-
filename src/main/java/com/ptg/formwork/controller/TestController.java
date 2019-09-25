package com.ptg.formwork.controller;

import com.ptg.formwork.base.BaseController;
import com.ptg.formwork.commons.RestResponseModel;
import com.ptg.formwork.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * className TestController
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/9/25 15:19
 */
@RestController
@RequestMapping
@Api(tags = "测试")
public class TestController extends BaseController {
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("/rechargeList")
    @ApiOperation(value = "获取学校充值列表", produces = "application/json;charset=UTF-8")
    public RestResponseModel phaseList() {
        redisUtil.set("1","111111");
        System.out.println(redisUtil.get("1"));
        return this.success(redisUtil.get("1"));
    }
}
