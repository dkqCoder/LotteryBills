package com.manito.bill;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfiguration {

    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties("spring.datasource")
    public DruidDataSource dataSource() {
        System.out.println("注入druid!!!");
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
