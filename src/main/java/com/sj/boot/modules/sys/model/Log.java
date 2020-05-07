package com.sj.boot.modules.sys.model;

import com.sj.boot.common.spring.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangrd
 * @date 2019/1/9
 **/

@Getter
@Setter

@Entity
@Table(name = "sys_log")
public class Log extends AbstractEntity<Log> {

    /**
     * 标题
     */
    private String title;

    /**
     * 请求路径
     */
    private String reqUri;

    /**
     * 请求方法类型
     */
    private String reqMethod;

    /**
     * 控制器名称
     */
    private String controller;

    /**
     * 处理请求的方法名称
     */
    private String methodName;

    /**
     * 来自哪个用户
     */
    private String username;

    /**
     * ip地址
     */
    private String addressIp;

    /**
     * 设备名称
     */
    private String driverName;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 异常信息
     */
    private String exceptionInfo;

    /**
     * 处理用时
     */
    private Long executeUseMillisecond;
}
