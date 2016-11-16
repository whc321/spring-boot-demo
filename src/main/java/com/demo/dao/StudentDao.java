package com.demo.dao;

import com.demo.model.Student;

/**
 * Created by wang_haichun on 2016/11/14.
 */
public interface StudentDao {

    Student findOne(Integer id);
}
