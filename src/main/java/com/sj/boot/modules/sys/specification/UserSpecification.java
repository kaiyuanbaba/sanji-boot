package com.sj.boot.modules.sys.specification;

import com.github.wenhao.jpa.Specifications;
import com.sj.boot.modules.sys.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * UserSpecification
 *
 * @author yangrd
 * @date 2019/05/31
 */
public class UserSpecification {

    public static Specification<User> toSpec(final User user) {
        return Specifications.<User>and()
                .like(StringUtils.isNotEmpty(user.getUsername()), "username", user.getUsername())
                .build();
    }
}
