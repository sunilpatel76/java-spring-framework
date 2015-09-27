package aaradhya.patel.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(classes={ApplicationConfiguration.class})
public abstract class AbstractWebApplication extends ApplicationExecutionListener{
    public String webBrowser;
    public String applicationURL;


    @Autowired
    private Environment environment;

    @BeforeClass
    public void loadInitConfig(){
        webBrowser= environment.getProperty("application.browser");
        applicationURL = environment.getProperty("application.URL");
    }


}
