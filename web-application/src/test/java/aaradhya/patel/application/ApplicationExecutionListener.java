package aaradhya.patel.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public abstract class ApplicationExecutionListener implements ApplicationContextAware {

    protected ApplicationContext applicationContext;
    private final TestContextManager contextManager;

    private Throwable testException;

    public ApplicationExecutionListener(){
        this.contextManager = new TestContextManager(getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @BeforeClass(alwaysRun = true)
    protected void testContextBeforeTestClass() throws Exception {
        this.contextManager.beforeTestClass();
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "testContextBeforeTestClass")
    protected void testContextPrepareTestInstance() throws Exception {
        this.contextManager.prepareTestInstance(this);
    }

    @BeforeMethod(alwaysRun = true)
    protected void testContextBeforeTestMethod(Method testMethod) throws Exception {
        this.contextManager.beforeTestMethod(this, testMethod);
    }

    @AfterMethod(alwaysRun = true)
    protected void testContextAfterTestMethod(Method testMethod) throws Exception {
        try {
            this.contextManager.afterTestMethod(this, testMethod, this.testException);
        }finally {
            this.testException = null;
        }
    }

    @AfterClass(alwaysRun = true)
    protected void testContextAfterTestClass() throws Exception {
        this.contextManager.afterTestClass();
    }

}
