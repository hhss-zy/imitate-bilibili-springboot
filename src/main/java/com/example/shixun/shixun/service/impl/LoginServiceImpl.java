package com.example.shixun.shixun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shixun.shixun.entity.Login;
import com.example.shixun.shixun.mapper.LoginMapper;
import com.example.shixun.shixun.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2021-12-11
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public Login login(int phone, String password) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("phone",phone);
        queryWrapper.eq("password",password);
        Login login=loginMapper.selectOne(queryWrapper);
        return login;
    }

    @Override
    public Login register(int phone) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("phone",phone);
        Login login=loginMapper.selectOne(queryWrapper);
        return login;
    }
}
