package com.example.song.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyListEntity {
    public List<CompanyEntity> list = new ArrayList<>();

    public List<CompanyEntity> getList() {
        return list;
    }

    public void setList(List<CompanyEntity> list) {
        this.list = list;
    }
}
