package com.taotao.service;

import com.taotao.pojo.TbItem;

/**
 * @author zhaoqiankai
 * @Description search good by id
 * @since 2018/9/14
 */
public interface ItemService {
    TbItem getItemById(Long itemId);
}
