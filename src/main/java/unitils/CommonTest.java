package unitils;

import org.testng.annotations.BeforeClass;
import org.unitils.core.Unitils;

/**
 * Created by dreamyao on 2017/5/26.
 */
public class CommonTest extends Unitils {

    @BeforeClass
    public void initUnitils(){
        init();
        this.getTestListener().beforeTestClass(this.getClass());
    }
}
