package com.demo.model;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2016/11/14.
 */
public class Student implements Serializable{

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
