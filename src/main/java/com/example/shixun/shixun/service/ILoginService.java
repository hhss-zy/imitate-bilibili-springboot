package com.example.shixun.shixun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shixun.shixun.entity.Login;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-12-11
 */
public interface ILoginService {
    Login login(int phone,String password);
    Login register(int phone);

}
