package ru.kuper.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Ilya V. Kupriyanov
 * @version 11.03.2022
 */
@Component
public class ColorFrame extends JFrame {

    @Autowired
    private ApplicationContext context;

//    @Autowired
//    private Color color;

    public ColorFrame() throws HeadlessException {
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void shoeOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(context.getBean(Color.class));
        repaint();
    }

}
