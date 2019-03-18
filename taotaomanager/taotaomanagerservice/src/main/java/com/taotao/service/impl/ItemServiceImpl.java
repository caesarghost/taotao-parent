package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
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

        /*@Override
        public List<TbItem> selectByExample(TbItemExample example){
            List<TbItem> list = tbItemMapper.selectByExample(example);
            return list;
        }*/

        //接收页面参数？
        //查询
        //接收返回值

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page,rows);

        //执行查询
        TbItemExample example = new TbItemExample();//example对象是？？？
        List<TbItem> list = tbItemMapper.selectByExample(example);

        //取分页信息
        PageInfo pageInfo = new PageInfo(list);

        //返回处理结果
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public int addItem(TbItem tbItem) {
        int a = tbItemMapper.insert(tbItem);
        return a;
    }


}
