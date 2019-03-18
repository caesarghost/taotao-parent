package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUINodeTree;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 商品分类管理
 * @Author: Zhao, Qiankai
 * @CreateDate: 2019/1/9
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<EasyUINodeTree> getItemCatList(long parentId) {
        //根据parentid 查询分类列表
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        //转换成树形列表
        List<EasyUINodeTree> resultList = new ArrayList<>();
        for(TbItemCat tbItemCat:list){
            //创建一个节点对象 //创建对象，添加对象到list
            EasyUINodeTree node = new EasyUINodeTree();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            //是父节点就关闭，不是就开启
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            //节点添加到列表中
            resultList.add(node);
        }
        return resultList ;
    }
}

