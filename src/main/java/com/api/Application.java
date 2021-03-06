package com.api;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.api.mapper")
public class Application
{

    public static void main(String[] args)
    {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationStartUpListener());
        application.run(args);

       // SpringApplication.run(Application.class, args);
    }

}
