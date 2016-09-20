package com.solvent;

import org.apache.log4j.*;

import java.io.File;
import java.util.UUID;

/**
 * Created by DreamYao on 2016/6/13.
 */
public class SolventLogger {
    private static final String CONSOLE_APPENDER_NAME= UUID.randomUUID().toString();
    public static final String FILE_APPENDER_NAME=UUID.randomUUID().toString();
    /**
     * 根日志记录器
     */
    private static Logger root= LogManager.getRootLogger();
    /**
     * 确认Log4j是不是已经配置了
     */
    private static boolean configuredExternally=root.getAllAppenders().hasMoreElements();
    /**
     * 配置类中获取日志格式和级别
     */
    private static String defaultPattern= com.solvent.Configurator.getSolventOutputPattern();
    private static String defaultVerbosity=Configurator.getSolventOutputVerbosity();
    static {initializelogging(defaultPattern,defaultVerbosity,null);}
    /**
     * 静态块中调用初始化日志发方法，只初始化控制台，不设置文件输出
     */
    public static void initializelogging(String pattern, String verbosity, File logFile){
        //调用前述日志，确保Log4j没有被重复设置
        if (!configuredExternally){
            root.removeAppender(CONSOLE_APPENDER_NAME);
            //去除可能存在的控制台Appender，并新建一个
            Appender conApp=new ConsoleAppender(new PatternLayout(pattern));
            conApp.setName(CONSOLE_APPENDER_NAME);
            //将该Appender添加到root下面，后续所有的Logger都将使用到
            root.addAppender(conApp);
            root.setLevel(Level.toLevel(verbosity,Level.ALL));
            //建立文件Appender，过程类似上述控制台Appender
            if (logFile!=null){
                try {
                    Appender fileApp=new FileAppender(new PatternLayout(pattern),logFile.getPath());
                    fileApp.setName(FILE_APPENDER_NAME);
                    root.addAppender(fileApp);
                }catch (Throwable t){
                    t.printStackTrace();
                }
            }
        }
    }
    public static void disableFileLogging(){
        root.removeAppender(FILE_APPENDER_NAME);
    }
    public static Logger getLogger(Class<?> clazz){
        return getLogger(clazz.getName());
    }
    public static Logger getLogger(String name){
        return LogManager.getLogger("solvent."+name);
    }
}
