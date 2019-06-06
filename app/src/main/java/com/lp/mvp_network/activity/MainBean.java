package com.lp.mvp_network.activity;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/9/19
 */

public class MainBean {
    /**
     * id : 11
     * act_logo : http://www.energy-link.com.cn/upload/admin/20180828/s_29a692567d0f0d84d515eb5cf5be98d0.jpg
     * play_time : 2018-06-10
     * name : 中国生物质能源产业联盟会员代表大会
     * province : 北京市
     * city : 西城区
     */

    private int id;
    private String act_logo;
    private String play_time;
    private String name;
    private String province;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAct_logo() {
        return act_logo;
    }

    public void setAct_logo(String act_logo) {
        this.act_logo = act_logo;
    }

    public String getPlay_time() {
        return play_time;
    }

    public void setPlay_time(String play_time) {
        this.play_time = play_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "MainBean{" +
                "id=" + id +
                ", act_logo='" + act_logo + '\'' +
                ", play_time='" + play_time + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
