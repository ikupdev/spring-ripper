package ru.kuper.screensaver;

import org.springframework.context.annotation.*;

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
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).shoeOnRandomPlace();
            Thread.sleep(50);
        }
    }
}
