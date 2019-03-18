package com.taotao.controller;

import com.taotao.common.pojo.EasyUINodeTree;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 商品分类管理
 * @Author: Zhao, Qiankai
 * @CreateDate: 2019/1/9
 */
@Controller
@RequestMapping("/item/cat")//这样写，窄化请求映射
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    //参数 parentsId
    //返回json数据，用ResponseBody
    //参数不匹配的时候，用RequestParam注解，将取到的id，赋值给parentId
    public List<EasyUINodeTree> getItemCatList(@RequestParam(value = "id",defaultValue = "0")Long parentId){
        List<EasyUINodeTree> list = itemCatService.getItemCatList(parentId);
        return list;
    }
}

