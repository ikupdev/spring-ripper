package ru.kuper;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ilya V. Kupriyanov
 * @version 10.03.2022
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        while (true) {
            Thread.sleep(100);
            context.getBean(Quoter.class).sayQuote();
        }
    }
}
