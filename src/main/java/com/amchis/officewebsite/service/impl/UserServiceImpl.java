package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.User;
import com.amchis.officewebsite.jpa.UserRepository;
import com.amchis.officewebsite.service.UserService;
import com.amchis.officewebsite.utils.MD5Util;
import com.amchis.officewebsite.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse<JSONObject> register(User user) {
        String username = user.getUsername();
        User byUsername = userRepository.findByUsername(username);
        if (byUsername != null){
            return setResultError("用户已经存在");
        }
        String password = user.getPassword();
        String newPassword = MD5Util.MD5(password);
        user.setPassword(newPassword);
        userRepository.save(user);
        return setResultSuccess();
    }

    @Override
    public BaseResponse<JSONObject> login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String enPassword = MD5Util.MD5(password);
        User dbUser = userRepository.findByUsernameAndPassword(username, enPassword);
        if (dbUser != null){
            String token = UUID.randomUUID().toString();
            String userToken = tokenUtils.createToken("officewebsite", token, 3000L);
            return setResultSuccess(userToken);
        }
        return setResultError("用户不存在");
    }
}
