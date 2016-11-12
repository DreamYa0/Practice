package Java_AutoTest_Framework.solvent;


import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by DreamYao on 2016/6/9.
 */
public abstract class SolventTestCase {
    private static ArrayList<Timer> timers = null;
    private static ArrayList<CheckPoint> checkPoints = null;
    protected static Logger log;
    private final File directory=new File("./pic");
    private SolventTestDataSet data;
    private static String dataSetOverride;

    public SolventTestCase() {
        log = SolventLogger.getLogger(this.getClass());
//        I18NUtil.processI18NKeys(this);
        directory.mkdirs();
    }
    @Rule
    public TestRule watcher=new TestWatcher() {
        @Override
        public void failed(Throwable e, Description description) {
            silentlySaveScreenshotTo(filenameFor(description),"png");
        }
    };
    private File filenameFor(Description description){
        String className=description.getClassName();
        String methodName=description.getMethodName();
        return new File(directory,className+"_"+methodName+".png");
    }
    private void silentlySaveScreenshotTo(File file,String format){
        try {
            saveScreenshotTo(file,format);
        }catch (Exception e){
            System.err.println("Failed to screenshot to"+file+","+e);
        }
    }
//    private static BufferedImagetakeScreenshot() throws AWTException{
//        Robot robot=new Robot();
//        Rectangle captureSize=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//        return robot.createScreenCapture(captureSize);
//    }
    private static void saveScreenshotTo(File file,String format)throws AWTException,IOException{
//        ImageIO.write(takeScreenshot(),format,file);
    }

    @BeforeClass
    public static void setupClass() {
//        startHSQL();
    }

    @Before
    public void setup() {
        checkPoints = new ArrayList<CheckPoint>();
        timers = new ArrayList<Timer>();
        start();
        initializeDataSet();
    }
    private void initializeDataSet(){
        try {
            InputStream in=InputFileFinder.getInputFileAsStream(this);
            if (in!=null){
                log.info("Found test input...digesting file...");
                InputFileDigester digester=new InputFileDigester(in);
//                digester.parseDataSets(dataSetOverride.get());
                data = digester.getWorkingDataSet();
            }else {
                log.info("No  test input file found");
            }
        }catch (Exception e){
            log.error("Error while parsing input file..",e);
        }
    }
    public static void setDataSetOverride(String dataName){
        dataSetOverride=dataName;
    }
    public static String getDataSetOverride(){
        return dataSetOverride;
    }
    public SolventTestDataSet getData() throws SolventException {
        if(data==null){
            throw new SolventException("Cannot retrieve dataset. No dataset was found for this test class.");
        }else {
            return data;
        }
    }
    public void useDataSet(String dataSetName){
        setDataSetOverride(dataSetName);
        initializeDataSet();
    }

    protected abstract void start();

    public String uniquify(String str) {
        return str + "_" + System.currentTimeMillis();
    }

    public static void waitfor(long milles) {
        try {
            Thread.sleep(milles);
        } catch (Exception e) {
            log.info("\n\n time out with exception: " + e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        checkForFailures();
        checkTimers();
    }

    private void checkTimers() {
    }

    private void checkForFailures() throws SolventException {
        String exceptionMessage = "";
        boolean checkFailureFound = false;
        for (CheckPoint check : checkPoints) {
            if (!check.status()) {
                checkFailureFound = true;
                log.error(check.getStatusMessage());
            }
        }
        if (checkFailureFound) {
            exceptionMessage = exceptionMessage + "Found CheckPoint failures! See log for details";
        }
        if (!exceptionMessage.isEmpty()) {
            throw new SolventException(exceptionMessage);
        }
    }

    public static ArrayList<CheckPoint> getCheckPoints() {
        return checkPoints;
    }

    public CheckPoint newCheckPoint(String id) throws SolventException {
        return newCheckPoint(id, "");
    }

    public CheckPoint newCheckPoint(String id, String description) throws SolventException {
        if (!checkExists(id)) {
            CheckPoint check = new CheckPoint(id, description);
            checkPoints.add(check);
            return check;
        }
        throw new SolventException("Check with id:" + id + "already exists.Specify unique id for you check");
    }

    private boolean checkExists(String id) {
        for (CheckPoint check : checkPoints) {
           if (check.getId().equals(id)){
               return true;
           }
        }
        return false;
    }

    @AfterClass
    public static void tearDownClass() {
//        HsqldbHelper.stopHSQL();
    }

}
