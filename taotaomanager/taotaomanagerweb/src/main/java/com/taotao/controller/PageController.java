package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 页面跳转
 * @Author: Zhao, Qiankai
 * @CreateDate: 2018/11/26
 */
@Controller
public class PageController {
    //主页
    @RequestMapping("/")
    public String showIndex(){
        return "index";        //返回逻辑视图
    }

    //新增等页面内容可以统一处理！！
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}

