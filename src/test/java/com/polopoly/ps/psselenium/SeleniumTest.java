package com.polopoly.ps.psselenium;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(SeleniumTestRunner.class)
public class SeleniumTest {

    @Inject
    public SimpleGUIAgentInterface guiAgent;

    @Test
    public void simpleLoginLogoutAndQuitTest() {
        guiAgent.agentLogin().loginAsSysadmin();
        guiAgent.agentLogout().logout();
        guiAgent.getWebDriver().quit();
    }
}
