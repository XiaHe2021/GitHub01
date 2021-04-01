package com.turing.sb5.entity;

import lombok.Data;

@Data
public class Attributes {
    private String icon;  //图标
    private String url; //页面地址

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
