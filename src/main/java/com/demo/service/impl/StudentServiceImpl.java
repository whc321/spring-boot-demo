package com.demo.service.impl;

import com.demo.dao.StudentDao;
import com.demo.model.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wang_haichun on 2016/11/14.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao stuDao;

    @Override
    public Student findOne(Integer id) {
        return stuDao.findOne(id);
    }
}
