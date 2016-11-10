package Java_AutoTest_Framework.com.solvent;

import org.apache.log4j.Logger;
import java.io.InputStream;

/**
 * Created by DreamYao on 2016/6/13.
 */
public class InputFileFinder {
    private static final Logger log=SolventLogger.getLogger(InputFileFinder.class.getName());
    public static InputStream getInputFileAsStream(SolventTestCase testCase){
        return getInputFileAsStream(testCase.getClass());
    }

    private static InputStream getInputFileAsStream(Solvent solventClass) {
        return getInputFileAsStream(solventClass.getClass());
    }

    private static InputStream getInputFileAsStream(Class<?> testClass) {
        String packageName="";
        if (testClass.getPackage()!=null){
            packageName=testClass.getPackage().getName()+".";
        }
        String resourceBase=(packageName+testClass.getSimpleName()).replace('.','/');
        String resourceName;
        ClassLoader classLoader=testClass.getClassLoader();
        resourceName=resourceBase+".xml";
        log.info("Searching for default input file:"+resourceName);
        return classLoader.getResourceAsStream(resourceName);
    }
}
