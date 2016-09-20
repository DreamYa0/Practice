package com.solvent;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by DreamYao on 2016/6/13.
 */
public class tLogger {
    private static final Logger log=Logger.getLogger(tLogger.class);
    @Test
    public void test(){
        if (log.isDebugEnabled()){
            log.debug("debug is enabled.");
        }
        if (log.isInfoEnabled()){
            log.info("info is enabled.");
        }
    }
}
