package com.example.shixun.shixun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shixun.shixun.entity.AppInformation;
import com.example.shixun.shixun.entity.BaseModle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author czy
 * @since 2021-12-12
 */
public interface AppInformationMapper extends BaseMapper<AppInformation> {
    @Select("SELECT * FROM `app_information`")
    List<AppInformation> getvideodata();
}
