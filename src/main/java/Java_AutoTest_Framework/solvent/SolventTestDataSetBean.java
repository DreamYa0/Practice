package Java_AutoTest_Framework.solvent;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by DreamYao on 2016/6/13.
 */
public class SolventTestDataSetBean {
    private Hashtable<String,String>myVars=new Hashtable<String, String>();
    private Hashtable<String,ArrayList<String>>myVarLists=new Hashtable<String, ArrayList<String>>();
    private Hashtable<String,String>myFiles=new Hashtable<String, String>();
    private Hashtable<String,ArrayList<String>>myFileLists=new Hashtable<String, ArrayList<String>>();
    private String name;
    public SolventTestDataSetBean(String name){
        this.name=name;
    }
    public void addVar(String varName,String varVal){
        myVars.put(varName,varVal);
    }
    public void addVarList(String varName,ArrayList<String>valueList){
        myFileLists.put(varName,valueList);
    }
    public void addFile(String filename,String filePath){
        myFiles.put(filename,filePath);
    }
    public void addFiles(String filename,ArrayList<String>fileList){
        myFileLists.put(filename,fileList);
    }
    public String getName(){
        return this.name;
    }
    public String getVarValue(String varName){
        if (myVars.containsKey(varName)){
            return myVars.get(varName);
        }
        return null;
    }
    public ArrayList<String>getVarValues(String listName){
        if (myFileLists.containsKey(listName)){
            return myVarLists.get(listName);
        }
        return null;
    }
    public String getFile(String fileName){
        if (myFiles.containsKey(fileName)){
            return myFiles.get(fileName);
        }
        return null;
    }
    public ArrayList<String>getFiles(String listName){
        if (myFileLists.containsKey(listName)){
            return myFileLists.get(listName);
        }
        return null;
    }
}
