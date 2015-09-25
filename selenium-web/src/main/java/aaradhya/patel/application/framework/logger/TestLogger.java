package aaradhya.patel.application.framework.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    protected Logger logger;
    private String loggerName;

    public TestLogger(String loggerName){
        setLoggerName(loggerName);
    }

    private void setLoggerName(String loggerName){
        this.loggerName = loggerName;
    }
    public String getLoggerName(){
        return loggerName;
    }

    protected void setLogger(String logger){
        this.logger = LogManager.getLogger(logger);
    }

    public final void logInfo(String logMessage){
        logger.log(Level.INFO, "Sunil");
    }

}
