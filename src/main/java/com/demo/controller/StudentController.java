package com.demo.controller;

import com.demo.common.utils.RedisExtendsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wang_haichun on 2016/11/14.
 */
@Controller
public class StudentController extends BaseController {

    @Autowired
    private RedisExtendsUtils redisExtendsUtils;

    @RequestMapping("index")
    public String init(Model model){
        model.addAttribute("name","hello");
        return "index";
    }

    @RequestMapping("testRedis")
    public String testRedis(Model model){
        redisExtendsUtils.set("test","hello");
        String str = redisExtendsUtils.get("test");
        model.addAttribute("str",str);
        return "index";
    }

}
