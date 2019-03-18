package com.taotao.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description: 测试pagehelper
 * @Author: Zhao, Qiankai
 * @CreateDate: 2018/12/25
 */
public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //1.获取mapper代理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");//spring容器
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);//商品列表对象
        //2.修改sql语句，设置分页
        PageHelper.startPage(1,30);
        //3.进行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //4.获取查询结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        Long total = pageInfo.getTotal();
        System.out.println("total number is " + total);
        int pages = pageInfo.getPageNum();
        System.out.println("current page is " + pages);
        int talpages = pageInfo.getPages();
        System.out.println("total page is " +talpages);
        int size = pageInfo.getPageSize();
        System.out.println("total number every page " + size);
    }
}

