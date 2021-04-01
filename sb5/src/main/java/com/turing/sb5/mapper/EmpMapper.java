package com.turing.sb5.mapper;

import com.turing.sb5.entity.Emp;
import com.turing.sb5.entity.Emp2;
import com.turing.sb5.entity.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {

    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    /**
     * 级联查询
     * @param pageNum 当前页
     * @param pageSize 一页有多少条
     * @return
     */
    List<Emp2> SelectEmpAndDept(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 分页
     * @param PageNum 当前页
     * @param PageSize 一页有多少条
     * @return
     */
    @Select("select * from emp limit #{PageNum},#{PageSize}")
    List<Emp> findAllPage(@Param("PageNum") Integer PageNum,@Param("PageSize") Integer PageSize);

    /**
     * 查询总个数
     */
    @Select("select count(*) from emp")
    int selectCount();

    /**
     * 批量删除
     */
   int deleBatch(String[] str);
}