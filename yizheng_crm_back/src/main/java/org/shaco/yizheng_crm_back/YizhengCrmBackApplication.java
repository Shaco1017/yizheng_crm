package org.shaco.yizheng_crm_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class YizhengCrmBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(YizhengCrmBackApplication.class, args);
    }

}
