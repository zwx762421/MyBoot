package com.myself.sbdemo.pojo.menu;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "menu_info")
@Data
public class MenuInfo {
    /**
     * 菜单组件id
     */
    @Id
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 菜单显示名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单等级
     */
    @Column(name = "menu_level")
    private String menuLevel;

    /**
     * 可显示本菜单用户类型
     */
    @Column(name = "menu_display_user_type")
    private String menuDisplayUserType;

    /**
     * 是否可用
     */
    @Column(name = "is_inuse")
    private String isInuse;

}