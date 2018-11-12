package com.taotao.service.impl;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import com.taotao.mapper.TbItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoqiankai
 * @Description implement ItemService
 * @since 2018/9/14
 */
@Service
public class ItemServiceImpl implements ItemService {
        @Autowired //注入mapper
        private TbItemMapper tbItemMapper;
        @Override
        public TbItem getItemById(Long itemId) {
              TbItem item = tbItemMapper.selectByPrimaryKey(itemId);//根据主键查询
//                //根据查询条件查询
//                TbItemExample example = new TbItemExample();
//                //创建查询条件
//                TbItemExample.Criteria criteria = example.createCriteria();
//                criteria.andIdEqualTo(itemId);
//                List<TbItem> list = tbItemMapper.selectByExample(example);
//                //判断list是否为空
//                TbItem item = null;
//                if(list != null && list.size() > 0){
//                        item=list.get(0);
//                }
                return item;
        }

}
