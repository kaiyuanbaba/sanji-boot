package com.sj.boot.modules.sys.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sj.boot.common.spring.data.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author yangrd
 * @date 2019/1/9
 **/

@Getter
@Setter

@Entity
@Table(name = "sys_menu")
public class Menu extends AbstractEntity<Menu> implements GrantedAuthority {

    /**
     * 名称
     */
    private String name;

    /**
     *　图标
     */
    private String icon;

    /**
     *　描述
     */
    private String description;

    /**
     *　路径
     */
    private String url;

    /**
     *　排序字段
     */
    private Long sort;

    /**
     *　父级菜单
     */
    @ManyToOne
    private Menu parent;

    /**
     * 菜单类别对应的深度
     */
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    @Enumerated(EnumType.STRING)
    private Type depth;

    /**
     * 皮肤 查看skins.css对应的样式
     */
    private String skin;

    /**
     * 认证标识
     */
    private String authority;

    public enum Type {
        /**
         * 根
         */
        ROOT,
        /**
         * 系统
         */
        SYSTEM,
        /**
         * 目录
         */
        DIRECTORY,
        /**
         * 菜单
         */
        MENU
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
