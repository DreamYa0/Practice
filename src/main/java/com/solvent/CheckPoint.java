package com.solvent;

import org.apache.log4j.Logger;

/**
 * Created by DreamYao on 2016/6/13.
 */
public class CheckPoint {
    private final String id;
    private String description="";
    private Throwable error=null;
    private String message="";
    private boolean result=false;
    private static Logger log=SolventLogger.getLogger(CheckPoint.class.getName());
    private CheckPoint(String id) throws SolventException {
        if (id==null||id.trim().isEmpty()){
            throw new SolventException("CheckPoint ID cannot be <null> or an empty String!");
        }
        this.id=id;
        log.info("CheckPoint:"+id+"created.");
    }
    CheckPoint(String id, String description) throws SolventException {
        this(id);
        if (description==null){
            throw new SolventException("CheckPoint Description cannot be <null>!");
        }
        this.description=description;
    }
    public void validate(boolean condition,String failureMessage){
        if (condition){
            secceeded();
        }else {
            failed(failureMessage);
        }
    }
    public void validate(boolean condition){
        validate(condition,null);
    }
    public void failed(String errorMessage){
        result=false;
        message=prepareMessage(errorMessage,result);
        log.error(message);
    }
    public void failed(String message,Throwable t){
        result=false;
        this.message=message;
        this.error=t;
        log.error("CheckPoint:"+getId()+":"+message+"failed");
    }
    public void secceeded(){
        succeeded(null);
    }
    public void succeeded(String successMessage){
        result=true;
        this.message=prepareMessage(successMessage,result);
        log.info(this.message);
    }
    private String prepareMessage(String message,boolean success){
        StringBuilder text=new StringBuilder("CheckPoint:"+id);
        if (!description.trim().isEmpty()){
            text.append("("+description+")");
        }
        text.append(success?"succeeded.":"failed!");
        if (!(message==null||message.trim().isEmpty())){
            text.append(success?"Message:":"Reason:");
        }
        return text.toString();
    }
    public String getId(){
        return this.id;
    }
    public boolean status(){
        return result;
    }
    public Throwable getError(){
        return this.error;
    }
    public String getStatusMessage(){
        return message;
    }
    public String getDescription(){
        return description;
    }
}
