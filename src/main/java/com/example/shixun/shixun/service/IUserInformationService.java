package com.example.shixun.shixun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shixun.shixun.entity.UserInformation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-12-14
 */
public interface IUserInformationService  {
    UserInformation updatauser(int phone);

}
