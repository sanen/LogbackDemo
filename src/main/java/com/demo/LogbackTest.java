package com.demo;

import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackTest {
    private static final Logger log = LoggerFactory.getLogger(LogbackTest.class);
    
    public static void main(String[] args) {
        /*
        log.debug("main test !");
        log.trace("======trace");  
        log.debug("======debug");  
        log.info("======info");  
        log.warn("======warn");  
        log.error("======error");
        */ 
        
        testLogConfig();
        
    }
    
    public static void testLogConfig(){
        
        String methodName="testLogConfig";
        log.debug("{}() begin",methodName);
        
        Properties substProps = new Properties();
        substProps.put("LOG_ROOT", "log");
        substProps.put("CONTEXT_NAME", "context");
        substProps.put("WEB_APPLICATION_CONTEXT", "test");
        
        URL configUrl = LogbackTest.class.getResource("/logback.xml");
          
        JoranConfigurator configurator = new JoranConfigurator();
        LoggerContext context = new LoggerContext();
        for (Enumeration<?> propKeys = substProps.propertyNames(); propKeys
                .hasMoreElements();) {
            String propKey = (String) propKeys.nextElement();
            context.putProperty(propKey, substProps.getProperty(propKey));
        }
        
        configurator.setContext(context);
        try {
            configurator.doConfigure(configUrl);
            context.stop();
        } catch (JoranException e) {
            // StatusPrinter will handle this
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
        
        log.debug("{}() end",methodName);
        
    }
}
