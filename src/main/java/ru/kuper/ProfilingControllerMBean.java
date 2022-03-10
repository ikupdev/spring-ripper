package ru.kuper;

/**
 * @author Ilya V. Kupriyanov
 * @version 10.03.2022
 */
//MBean - MBeanServer - все объекты в нём через JMXConsule можно менять
public interface ProfilingControllerMBean {
    void setEnabled(boolean enabled);
}
