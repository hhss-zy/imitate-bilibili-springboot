package com.example.shixun.shixun.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shixun.shixun.entity.Login;
import com.example.shixun.shixun.entity.UserInformation;
import com.example.shixun.shixun.mapper.UserInformationMapper;
import com.example.shixun.shixun.service.IUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2021-12-14
 */
@Service
public class UserInformationServiceImpl implements IUserInformationService {

    @Autowired
    UserInformationMapper userInformationMapper;


    @Override
    public UserInformation updatauser(int phone) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("phone",phone);
        UserInformation userInformation=userInformationMapper.selectOne(queryWrapper);
        return userInformation;
    }
}
