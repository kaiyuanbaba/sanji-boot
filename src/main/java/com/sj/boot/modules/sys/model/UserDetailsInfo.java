package com.sj.boot.modules.sys.model;

import lombok.Data;

/**
 * @author yangrd
 * @date 2019/1/15
 **/
@Data
public class UserDetailsInfo {

    /**
     * 性别
     */
    private Gender gender;

    /**
     *　昵称
     */
    private String nickname;

    /**
     *　头像
     */
    private String avatar;

    /**
     *　邮箱
     */
    private String email;

    /**
     *　电话
     */
    private String phone;

    enum Gender {
        /**
         * 男
         */
        MAN,
        /**
         * 女
         */
        WO_MAN
    }
}
