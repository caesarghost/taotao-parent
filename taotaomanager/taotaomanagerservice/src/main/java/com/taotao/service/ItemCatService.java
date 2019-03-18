package com.taotao.service;

import com.taotao.common.pojo.EasyUINodeTree;

import java.util.List;

/**
 * 类目service
 */
public interface ItemCatService {

    List<EasyUINodeTree> getItemCatList(long parentid);
}
