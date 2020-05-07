package com.sj.boot.modules.sys.model;

import com.sj.boot.common.spring.data.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

/**
 * @author yangrd
 * @date 2019/1/9
 **/

@Getter
@Setter

@Entity
@Table(name = "sys_role")
public class Role extends AbstractEntity<Role> implements GrantedAuthority {

    private final static String ROLE_PREFIX = "ROLE_";

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 角色权限标示
     */
    private String authority;

    /**
     * 拥有的菜单
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Menu> menuSet;

    @Override
    public String getAuthority() {
        return Optional.ofNullable(authority).map(authority -> authority.contains(ROLE_PREFIX) ? authority : ROLE_PREFIX + authority).orElse(null);
    }
}
