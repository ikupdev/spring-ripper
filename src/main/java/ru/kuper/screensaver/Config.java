package ru.kuper.screensaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Random;

/**
 * @author Ilya V. Kupriyanov
 * @version 11.03.2022
 */
@Configuration
@ComponentScan(basePackages = "ru.kuper.screensaver")
public class Config {

    @Bean
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).shoeOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
