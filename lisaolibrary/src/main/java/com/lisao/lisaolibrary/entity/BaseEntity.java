package com.lisao.lisaolibrary.entity;


import java.io.Serializable;

/**
 * Created by lisao on 2016/1/7.
 * 基础的实体类
 */
public class BaseEntity implements Serializable {
    private long id;

    public BaseEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
