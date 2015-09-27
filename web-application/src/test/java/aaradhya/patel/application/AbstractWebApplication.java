package aaradhya.patel.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(classes={ApplicationConfiguration.class})
public abstract class AbstractWebApplication extends AbstractTestNGSpringContextTests{
    public String webBrowser;
    public String applicationURL;
    public String userName, passWd;


    @Autowired
    private Environment environment;

    @BeforeClass
    public void loadInitConfig(){
        webBrowser= environment.getProperty("application.browser");
        applicationURL = environment.getProperty("application.URL");
        userName= environment.getProperty("application.default.user");
        passWd= environment.getProperty("application.user.passwd");
    }


}
