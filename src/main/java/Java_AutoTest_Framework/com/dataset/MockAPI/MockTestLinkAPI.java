package Java_AutoTest_Framework.com.dataset.MockAPI;

import java.util.Map;

/**
 * Created by DreamYao on 2016/6/8.
 */
public class MockTestLinkAPI {
    public boolean login(Map<String, String> params) {
        System.out.println("************called login*************");
        System.out.println("Params::" + params.toString());
        System.out.println("**************************************");
        return true;
    }

    public void InsProject(Map<String, String> params) {
        System.out.println("************called InsProject*************");
        System.out.println("Params::" + params.toString());
        System.out.println("******************************************");
    }
}
