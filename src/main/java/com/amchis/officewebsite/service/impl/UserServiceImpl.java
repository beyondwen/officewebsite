package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.User;
import com.amchis.officewebsite.domain.UserDo;
import com.amchis.officewebsite.domain.viewdo.ViewUser;
import com.amchis.officewebsite.jpa.UserRepository;
import com.amchis.officewebsite.service.UserService;
import com.amchis.officewebsite.utils.MD5Util;
import com.amchis.officewebsite.utils.MeiteBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse<JSONObject> register(UserDo user) {
        String username = user.getUsername();
        User byUsername = userRepository.findByUsername(username);
        if (byUsername != null) {
            return setResultError("用户已经存在");
        }
        String password = user.getPassword();
        String newPassword = MD5Util.MD5(password);
        user.setPassword(newPassword);
        User user1 = MeiteBeanUtils.doToDto(user, User.class);
        userRepository.save(user1);
        return setResultSuccess();
    }

    @Override
    public BaseResponse<JSONObject> login(UserDo user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String enPassword = MD5Util.MD5(password);
        User dbUser = userRepository.findByUsernameAndPassword(username, enPassword);
        if (dbUser != null) {
            //String token = UUID.randomUUID().toString();
            //String userToken = tokenUtils.createToken("officewebsite", token, 3000L);
            ViewUser viewUser = MeiteBeanUtils.dtoToDo(dbUser, ViewUser.class);
            return setResultSuccess(viewUser);
        }
        return setResultError("用户不存在");
    }

}
