package com.turing.sb5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

//menu实体类
@Data
public class Menu {

      private Integer id;
      @JsonProperty(value = "text")
      private String name;
      private Integer pid;
      @JsonProperty(value = "children")
      private List<Menu> list;

      @JsonIgnore //序列号成json时，忽略该属性
      private String url; //页面地址
      @JsonIgnore
      private String icon; //图标
      private Attributes attributes;
      public String getUrl() {
            return url;
      }

      public void setUrl(String url) {
            this.url = url;
      }

      public String getIcon() {
            return icon;
      }

      public void setIcon(String icon) {
            this.icon = icon;
      }

      public Attributes getAttributes() {
            return attributes;
      }

      public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
      }



      public Integer getId() {
            return id;
      }

      public void setId(Integer id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public Integer getPid() {
            return pid;
      }

      public void setPid(Integer pid) {
            this.pid = pid;
      }

      public List<Menu> getList() {
            return list;
      }

      public void setList(List<Menu> list) {
            this.list = list;
      }
}
