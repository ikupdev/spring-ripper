package ru.kuper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Ilya V. Kupriyanov
 * @version 10.03.2022
 */
@Component
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            //Нельзя вытаскивать бин по имени, т.к. на этом этапе это будет уже прокси, поэтому используем ConfigurableListableBeanFactory
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            //оригинальное название класса
            String origClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(origClassName);
                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        //это работает только через cjlib, через dynamic proxy не будет
                        //method.invoke()
                        //нужно вытащить оригинальный класс, а не proxy
                        Object bean = context.getBean(name);
                        //bean.getClass() дает прокси
                        Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
