package com.turing.sb5.service.impl;

import com.turing.sb5.entity.Attributes;
import com.turing.sb5.entity.Menu;
import com.turing.sb5.mapper.MenuMapper;
import com.turing.sb5.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> findAll() {
        List<Menu> menus = menuMapper.findAll();
//        for(Menu menu:list){
//            menu.setList(menuMapper.findByID(menu.getId()));
//        }
        return findFatherMenu(menus);
    }

    /**
     * 查询所有父菜单
     * @param menus 所有菜单
     * @return 返回一个父菜单集合
     */
    private List<Menu> findFatherMenu(List<Menu> menus) {
        //父菜单集合
        List<Menu> list=new ArrayList<>();
          //遍历所以菜单
          for (Menu menu:menus){
               if(menu.getPid()==0){//根据pid判断是否是父菜单
                   menu.setList(findChildMenu(menu.getId(),menus));//根据父菜单ID查询子菜单

                   list.add(menu);//把父菜单装入集合中
               }
          }
          return list;
    }

    /**
     * 查询所有子菜单
     * @param id 父菜单id
     * @param menus 所有菜单集合
     * @return
     */
    private List<Menu> findChildMenu(Integer id, List<Menu> menus) {
        //子菜单集合
        List<Menu> Childlist=new ArrayList<>();
            //遍历
            for (Menu menu:menus){
                //如果pid 等于父菜单传入的ID就装入list集合中
                if(menu.getPid()==id){
                    Childlist.add(menu);
                    //设置属性
                    Attributes att = new Attributes();
                    att.setUrl(menu.getUrl());
                    att.setIcon(menu.getIcon());
                    menu.setAttributes(att);
                    menu.setList(findChildMenu(menu.getId(),menus));
                }
            }
            return Childlist;
    }

}
