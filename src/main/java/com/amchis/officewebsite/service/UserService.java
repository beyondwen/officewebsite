package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "用户相关")
public interface UserService {

    @PostMapping("/register")
    @ApiOperation("用户注册")
    BaseResponse<JSONObject> register(@RequestBody User user);

    @PostMapping("/login")
    @ApiOperation("用户登录")
    BaseResponse<JSONObject> login(@RequestBody User user);
}
