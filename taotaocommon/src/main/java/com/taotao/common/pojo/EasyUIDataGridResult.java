package com.taotao.common.pojo;

import java.util.List;

/**
 * @Description: 存放easyui页面返回值，因为返回的是json形式的：Easyui中datagrid控件要求的数据格式为：
{total:”2”,rows:[{“id”:”1”,”name”,”张三”},{“id”:”2”,”name”,”李四”}]}
应该放到taotao-common工程中，和其他系统共用。
 * @Author: Zhao, Qiankai
 * @CreateDate: 2019/1/8
 */
public class EasyUIDataGridResult {

    private Long total;
    private List<?> rows;//泛型？指代不确定

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

