package configuration;

import org.slf4j.LoggerFactory;

public class Reporter {

    public Reporter(){}


    /**
     * @return all the logger at LoggerFactory
     */
    private static org.slf4j.Logger getLogger(){return LoggerFactory.getLogger(Reporter.class);}

    /**
     * @param text shows the info of the test progress
     */
    public static void info(String text){
        getLogger().info(text);
    }

    /**
     * @param text shows the ingo of the test failures
     */
    public static void error(String text){
        getLogger().error(text);
    }
}
