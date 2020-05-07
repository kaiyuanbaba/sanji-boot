package com.sj.boot.modules.sys.model;

import com.sj.boot.common.spring.data.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yangrd
 * @date 2019/1/9
 **/

@Getter
@Setter

@Entity
@Table(name = "sys_user")
public class User extends AbstractEntity<User> implements UserDetails {

    /**
     * 用户名
     */
    @Column(unique = true, updatable = false)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * 状态
     */
    private UserStatus status;

    /**
     * 角色
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Set<Role> roleSet;

    /**
     * 明细
     */
    @Embedded
    private UserDetailsInfo details;

    {
        status = UserStatus.NORMAL;
        details = new UserDetailsInfo();
    }

    public enum UserStatus {
        /**
         * 正常
         */
        NORMAL,
        /**
         * 异常
         */
        ABNORMAL,
        /**
         * 冻结
         */
        FROZEN
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(this.roleSet);
        grantedAuthorities.addAll(this.roleSet.stream().map(Role::getMenuSet).flatMap(Set::stream).collect(Collectors.toList()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !UserStatus.FROZEN.equals(this.status);
    }

}
