package com.myself.sbdemo.api.menu.vo;

import lombok.Data;

/**
 * 菜单菜单出参VO（一级二级三级均可用此VO接参）
 */
@Data
public class MenuInfoVo {

    /**
     * 菜单Id
     */
    private String menuId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * url
     */
    private String url;

    /**
     * 菜单等级
     */
    private String menuLevel;
}
