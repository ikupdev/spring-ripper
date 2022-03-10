package ru.kuper;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ilya V. Kupriyanov
 * @version 10.03.2022
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(TerminatorQuoter.class).sayQuote();
    }
}
