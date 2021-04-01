package com.turing.sb5.controller;

import com.turing.sb5.entity.Dept;
import com.turing.sb5.entity.EasyUIDataGrid;
import com.turing.sb5.entity.Emp;
import com.turing.sb5.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {

      @Autowired
      private EmpService empService;


      //分页查询
    @GetMapping("/page")
    @ResponseBody
     public EasyUIDataGrid findByPage(@RequestParam(value = "page",defaultValue = "1") Integer PageNum,@RequestParam(value = "rows",defaultValue = "10") Integer PageSize){
          return  empService.SelectEmpAndDept(PageNum,PageSize);
     }
     //批量删除
     @GetMapping("/deleBach")
     @ResponseBody
     public String deleBa(String[] str){
        empService.deleBatch(str);
        return "success";
     }

      @GetMapping("/")
      public String findAll(Model model){
          List<Emp> EmpAll = empService.findAll();
          if(EmpAll!=null){
              model.addAttribute("EmpAll",EmpAll);
              return "index";
          }else{
              return null;
          }
      }
      @PostMapping("/AddEmp")
      @ResponseBody
      public String AddEmp(Emp emp){
          return empService.AddEmp(emp)>0?"success":"error";
      }

      @PostMapping("/update")
      @ResponseBody
      public String UpdateEmp(Emp emp){
           return empService.updateEmp(emp)>0?"success":"error";
      }

      @GetMapping("/deleEmp")
      public String deleEmp(Integer id){
          return empService.deleEmp(id)>0?"redirect:/emp/":"";
      }

      @GetMapping("/DeptAll")
      @ResponseBody
      public List<Dept>  findByDeptno(){
          return empService.findByDeptno();
      }
}
