package cn.autumnclouds.sgms;

import cn.autumnclouds.sgms.core.ui.CommandLineInterface;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

/**
 * @author Fu Qiujie
 * @since 2024/3/30
 */
@SpringBootApplication
@MapperScan("cn.autumnclouds.sgms.mapper")
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        CommandLineInterface commandLineInterface = context.getBean(CommandLineInterface.class);
        commandLineInterface.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            commandLineInterface.handleInput(scanner.nextLine());
        }
    }
}