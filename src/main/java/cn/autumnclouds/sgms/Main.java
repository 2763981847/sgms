package cn.autumnclouds.sgms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Fu Qiujie
 * @since 2024/3/30
 */
@SpringBootApplication
@MapperScan("cn.autumnclouds.sgms.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        while(true){
            System.out.println("Hello, World!");
        }
    }
}