package com.turing.sb5.entity;

import lombok.Data;

import java.util.List;

@Data
public class EasyUIDataGrid {

    private Integer total; //总个数
    private List<?> rows;//当前页显示数据

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
