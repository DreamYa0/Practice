package TestNG.httpclient;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by DreamYao on 2016/5/17.
 */
public class PropertiesHandler {
    private static Properties loadPropertiesFile(String filePath) {
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(new File(filePath));
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
    /**
     * 将property转换成Map
     * @param filePath
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String, String> getPropertyData(String filePath){
        try{
            return new HashMap<String, String>((Map)PropertiesHandler.loadPropertiesFile(filePath));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new HashMap<String, String>();
    }

    public static void main(String[] args) {
        System.out.println(PropertiesHandler.getPropertyData("file/data.properties"));
    }
}
