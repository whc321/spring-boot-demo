
package com.demo.rest;

import com.demo.common.utils.RedisExtendsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.base.BaseRsController;
import com.demo.model.Student;
import com.demo.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Created by wang_haichun on 2016/11/15.
 */

@RestController
@Api(description = "swagger测试接口SweggerController",tags = {"SweggerController"})
public class SweggerController extends BaseRsController {

    @Autowired
    private StudentService stuService;

    @Autowired
    private RedisExtendsUtils redisExtendsUtils;

    @ApiOperation(value = "swagger测试接口" , notes = "swagger测试接口")
    @RequestMapping(value = "/student/_search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student searchStudent(@RequestBody Student student){
        if(null != student && null != student.getId()){
            student = stuService.findOne(student.getId());
            return student;
        }
        return null;
    }


    @ApiOperation(value = "测试redis" , notes = "测试redis")
    @RequestMapping(value = "/redis/_search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student testRedis(@RequestBody Student student){
        redisExtendsUtils.set("test","hello");
        String str = redisExtendsUtils.get("test");
        student.setName(str);
        return student;
    }


}

