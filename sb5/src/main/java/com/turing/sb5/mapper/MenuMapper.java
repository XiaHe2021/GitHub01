package com.turing.sb5.mapper;

import com.turing.sb5.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//Menu接口
public interface MenuMapper {
//    MenuMapper@Select("select * from menu where pid=0")
//    public List<Menu> findAll();
//
//    @Select("select * from menu where pid=#{id}")
//    public List<Menu> findByID(@Param("id") Integer id);
      @Select("select * from menu")
      public List<Menu> findAll();
}
