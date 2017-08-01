package com.example.song.entity;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 家乡属性
 */
@Component
@ConfigurationProperties(prefix = "home")
public class HomeEntity {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 描述
     */
    private String desc;
}
