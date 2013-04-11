package com.polopoly.ps.psselenium;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SeleniumTestRunner extends BlockJUnit4ClassRunner {

    private static Injector injector;
    private static Object initLock = new Object();

    public SeleniumTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
        initInjectorIfNecessary();
    }

    private void initInjectorIfNecessary() {
        synchronized (initLock) {
            if (injector == null) {
                injector = Guice.createInjector(new SeleniumTestModule());
            }
        }
    }

    @Override
    protected Object createTest() throws Exception {
        Object obj = super.createTest();
        injector.injectMembers(obj);
        return obj;
    }
}
