package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * @author zhaoqiankai
 * @Description search good by id
 * @since 2018/9/14
 */
public interface ItemService {

    TbItem getItemById(Long itemId);

//    List<TbItem> selectByExample(TbItemExample example);
    EasyUIDataGridResult getItemList(int page, int rows);

    //add tbitem ,return code judge suc or err
    int addItem(TbItem tbItem);
}
