package com.sunzm.personmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.sunzm.personmall.user.mapper")
public class PersonmallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonmallUserServiceApplication.class, args);
    }

}
