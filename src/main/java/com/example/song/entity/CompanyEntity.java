package com.example.song.entity;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class CompanyEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(nullable = false, name = "code")
    private String code;

    @Column(name = "boss")
    private String boss;

    @Column(name = "reg")
    private String reg;

    @Column(name = "date")
    private String date;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
