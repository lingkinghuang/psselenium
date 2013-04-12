package com.polopoly.ps.psselenium;

import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class SimpleGUIAgentProvider implements Provider<SimpleGUIAgent> {

    @Override
    public SimpleGUIAgent get() {
        return SimpleGUIAgent.getAgent();
    }

}
