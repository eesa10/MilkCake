package com.sparta.mc;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AppLogger {
    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static void writeLog(String args,String Flag) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new CustomFormatter());
        logger.setUseParentHandlers(false);

        logger.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.addHandler(FileHandlerConfig.getFileHandler());
        if(Flag.equals("INFO")){
            logger.log(Level.INFO, args);
        }else if (Flag.equals("WARNING")){
            logger.log(Level.WARNING, args);
        }
       else{
            logger.log(Level.FINE, args);
        }


    }
}
