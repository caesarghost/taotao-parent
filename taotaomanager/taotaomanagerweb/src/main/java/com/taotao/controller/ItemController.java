package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoqiankai
 * @Description 商品查询
 * @since 2018/9/14
 */
@Controller

public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    private TbItem getItemById(@PathVariable Long itemId){
        TbItem Item = itemService.getItemById(itemId);
        return Item;
    }

    //如何从easyui页面接收参数值？
    //easyui可以带过来，能直接获取，使用
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){//用Integer 不用int，因为int可为空
        EasyUIDataGridResult result = itemService.getItemList(page,rows);
        return result;
    }

    @RequestMapping("/item/add")
    @ResponseBody
    public int addItem(TbItem tbItem){
        int a = itemService.addItem(tbItem);
        return a;
    }
}
