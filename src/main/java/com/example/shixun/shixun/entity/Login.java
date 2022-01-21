package com.example.shixun.shixun.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-12-11
 */
@Data
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer phone;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
            "id=" + id +
            ", phone=" + phone +
            ", password=" + password +
        "}";
    }
}
