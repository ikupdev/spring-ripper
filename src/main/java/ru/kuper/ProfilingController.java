package ru.kuper;

/**
 * @author Ilya V. Kupriyanov
 * @version 10.03.2022
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
