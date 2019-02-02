package com.explore.gateway.constant;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/1/31 17:06
 */
public enum  EnumIgnoreAuthPath {
    LOGIN("/login"),
    LOGOUT("/logout"),
    GUEST("/guest");


    private String desc;

    EnumIgnoreAuthPath(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
