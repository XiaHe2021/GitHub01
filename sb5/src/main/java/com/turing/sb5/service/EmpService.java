package com.turing.sb5.service;

import com.turing.sb5.entity.Dept;
import com.turing.sb5.entity.EasyUIDataGrid;
import com.turing.sb5.entity.Emp;

import java.util.List;

//员工接口
public interface EmpService {

    public void deleBatch(String [] str);

    /**
     * 级联查询分页
     * @return
     */
    public EasyUIDataGrid SelectEmpAndDept(Integer pageNum,Integer pageSize);


    /**
     * 查询所有员工
     * @return 返回一个集合
     */
    public List<Emp> findAll();

    /**
     * 添加员工
     * @param emp 员工对象
     * @return 返回影响行数
     */
    public int AddEmp(Emp emp);

    /**
     * 根据id删除员工
     * @param id 员工id
     * @return
     */
    public int deleEmp(Integer id);

    /**
     * 根据id修改员工
     * @param id 员工id
     * @return
     */
    public int updateEmp(Emp emp);

    /**
     * 根据id查询员工
     * @param id 员工id
     * @return
     */
    public Emp findByID(Integer id);

    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> findByDeptno();
}
