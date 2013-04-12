package com.polopoly.ps.psselenium;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.AbstractModule;
import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

public class SeleniumTestModule extends AbstractModule {

    private boolean instantiateNow;

    public SeleniumTestModule() {
        this(false);
    }

    public SeleniumTestModule(boolean instantiateNow) {
        setInstantiateNow(instantiateNow);
    }

    @Override
    public void configure() {
        if (isInstantiateNow()) {
            WebDriverTestSetup driverSetup = new WebDriverTestSetup(new FirefoxDriver());
            bind(SimpleGUIAgentInterface.class).toInstance(new SimpleGUIAgent(driverSetup));
        } else {
            // lazy binding
            bind(SimpleGUIAgentInterface.class).toProvider(new SimpleGUIAgentProvider());
        }
    }

    private boolean isInstantiateNow() {
        return instantiateNow;
    }

    private void setInstantiateNow(boolean instantiateNow) {
        this.instantiateNow = instantiateNow;
    }
}
