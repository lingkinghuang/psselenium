package com.polopoly.ps.psselenium;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.AbstractModule;
import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

public class SeleniumTestModule extends AbstractModule {

    @Override
    public void configure() {
        WebDriverTestSetup driverSetup = new WebDriverTestSetup(new FirefoxDriver());
        bind(SimpleGUIAgentInterface.class).toInstance(new SimpleGUIAgent(driverSetup));
    }
}
