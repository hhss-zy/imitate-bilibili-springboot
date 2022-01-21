package com.example.shixun.shixun.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-12-12
 */
@TableName("app_information")
@Data
public class AppInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String headimage;

    private String username;

    private String videoimage;

    private String videoparh;

    private String videotime;

    private String videotitle;

    private String uploadtime;

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getVideoimage() {
        return videoimage;
    }

    public void setVideoimage(String videoimage) {
        this.videoimage = videoimage;
    }
    public String getVideoparh() {
        return videoparh;
    }

    public void setVideoparh(String videoparh) {
        this.videoparh = videoparh;
    }
    public String getVideotime() {
        return videotime;
    }

    public void setVideotime(String videotime) {
        this.videotime = videotime;
    }
    public String getVideotitle() {
        return videotitle;
    }

    public void setVideotitle(String videotitle) {
        this.videotitle = videotitle;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "AppInformation{" +
            "headimage=" + headimage +
            ", username=" + username +
            ", videoimage=" + videoimage +
            ", videoparh=" + videoparh +
            ", videotime=" + videotime +
            ", videotitle=" + videotitle +
            ", uploadtime=" + uploadtime +
        "}";
    }
}
