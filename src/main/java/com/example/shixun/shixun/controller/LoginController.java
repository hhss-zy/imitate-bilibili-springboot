package com.example.shixun.shixun.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shixun.shixun.entity.AppInformation;
import com.example.shixun.shixun.entity.BaseModle;
import com.example.shixun.shixun.entity.Login;
import com.example.shixun.shixun.entity.UserInformation;
import com.example.shixun.shixun.mapper.AppInformationMapper;
import com.example.shixun.shixun.mapper.LoginMapper;
import com.example.shixun.shixun.mapper.UserInformationMapper;
import com.example.shixun.shixun.service.ILoginService;
import com.example.shixun.shixun.service.IUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-12-11
 */
@Controller
@RequestMapping("shixun")
public class LoginController {
    @Autowired
    LoginMapper loginMapper;

    @Autowired
    AppInformationMapper appInformationMapper;
    @Autowired
    UserInformationMapper userInformationMapper;
    @Autowired
    ILoginService iLoginServicel;
    @Autowired
    IUserInformationService iUserInformationService;

    @RequestMapping("login")
    @ResponseBody
    public BaseModle login(int phone,String password){
        Login login=iLoginServicel.login(phone,password);
        BaseModle baseModle;
        if (login==null){
            baseModle = new BaseModle(201, "登陆失败",null);
        }else {
            baseModle = new BaseModle(200, "登陆成功",login);
        }
        return baseModle;
    }
    @RequestMapping("register")
    @ResponseBody
    public BaseModle register(@RequestBody Login login){
        Login log=iLoginServicel.register(login.getPhone());
        BaseModle baseModle;
        if (log==null){
            Login log1=new Login();
            log1.setPhone(login.getPhone());
            log1.setPassword(login.getPassword());
            baseModle = new BaseModle(200, "注册成功",null);
            loginMapper.insert(log1);
            UserInformation userInformation=new UserInformation();
            userInformation.setPhone(login.getPhone());
            userInformationMapper.insert(userInformation);
        }else {
            baseModle = new BaseModle(201, "注册失败",null);

        }
        return baseModle;
    }
    @RequestMapping("videodata")
    @ResponseBody
    public BaseModle<AppInformation> getvideodata(){
        BaseModle<AppInformation> baseModle;
        List<AppInformation> datas=appInformationMapper.getvideodata();
        baseModle= new BaseModle(200, "获取视频数据成功",datas);
        return  baseModle;
    }
    @RequestMapping("uploaduser")
    @ResponseBody
    public BaseModle userdata(@RequestBody UserInformation userInformation){
        UserInformation u1=iUserInformationService.updatauser(userInformation.getPhone());
        BaseModle baseModle;
        if (u1!=null){
            UserInformation u2=new UserInformation();
            u2.setUsername(userInformation.getUsername());
            u2.setBrithday(userInformation.getBrithday());
            u2.setSex(userInformation.getSex());
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("phone",userInformation.getPhone());
//            UserInformation lastdata=userInformationMapper.selectOne(queryWrapper);
            userInformationMapper.update(u2,queryWrapper);

            baseModle = new BaseModle(200, "修改成功",null);
        }else {
            baseModle = new BaseModle(201, "修改失败",null);
        }
        return baseModle;
    }
    @RequestMapping("uploaduserfile")
    @ResponseBody
    public BaseModle uploaduserfile(@RequestBody MultipartFile file,int phone) {
        String dirpath = "E:" + File.separator + "upload";
        File iamgepath = new File(dirpath);
        if (!iamgepath.exists()) {
            iamgepath.mkdirs();
        }
        String filename = System.currentTimeMillis() + file.getOriginalFilename();
        File file1 = new File(iamgepath, filename);
        BaseModle baseModle;
        try {
            file.transferTo(file1);
            baseModle = new BaseModle(201, "上传失败", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseModle = new BaseModle(200, "上传成功", null);
        UserInformation u2 = new UserInformation();
        u2.setUserimage(filename);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone", phone);
        userInformationMapper.update(u2, queryWrapper);
        return baseModle;
     }
    @RequestMapping("getuserdata")
    @ResponseBody
    public BaseModle getuserdata( int phone){
        UserInformation userInformation=iUserInformationService.updatauser(phone);
        BaseModle baseModle;
        if (userInformation==null){
            baseModle = new BaseModle(201, "失败",null);
        }else {
            baseModle = new BaseModle(200, "成功",null);
            baseModle.setData(userInformation);
        }
        return baseModle;
    }
}
