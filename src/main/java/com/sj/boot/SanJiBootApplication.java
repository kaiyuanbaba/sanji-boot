package com.sj.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yangrd
 * @date 2019/1/8
 **/
@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
public class SanJiBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanJiBootApplication.class, args);
    }
}
