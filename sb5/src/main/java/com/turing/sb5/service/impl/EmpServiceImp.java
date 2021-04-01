package com.turing.sb5.service.impl;

import com.turing.sb5.entity.Dept;
import com.turing.sb5.entity.EasyUIDataGrid;
import com.turing.sb5.entity.Emp;
import com.turing.sb5.mapper.DeptMapper;
import com.turing.sb5.mapper.EmpMapper;
import com.turing.sb5.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImp implements EmpService{

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public void deleBatch(String[] str) {
           empMapper.deleBatch(str);
    }

    @Override
    public EasyUIDataGrid SelectEmpAndDept(Integer PageNum, Integer PageSize) {
        EasyUIDataGrid grid=new EasyUIDataGrid();
        grid.setTotal(empMapper.selectCount());
        grid.setRows(empMapper.SelectEmpAndDept((PageNum-1)*PageSize,PageSize));
        return grid;
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.selectByExample(null);
    }

    @Override
    public int AddEmp(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int deleEmp(Integer id) {
        return empMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateByPrimaryKey(emp);
    }

    @Override
    public Emp findByID(Integer id) {
        return null;
    }

    @Override
    public List<Dept> findByDeptno() {
        return deptMapper.selectByExample(null);
    }
}
