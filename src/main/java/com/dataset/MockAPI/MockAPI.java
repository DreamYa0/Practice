package com.dataset.MockAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DreamYao on 2016/6/8.
 */
public class MockAPI {
    private MockTestLinkAPI api = new MockTestLinkAPI();
    public static final String[] loginArray = {"", "", "username", "password", "", ""};
    public static final String[] InsProjectArray = {"id", "name", "notes", "prefix", "isActive", "isPublic"};

    public boolean login(String[] valuses) {
        Map<String, String> map = getParamMap(loginArray, valuses);
        if (map != null) {
            return api.login(map);
        } else {
            return false;
        }
    }

    public void InsProject(String[] valuses) {
        Map<String, String> map = getParamMap(loginArray, valuses);
        if (map != null) {
            api.InsProject(map);
        }
    }

    private Map<String, String> getParamMap(String[] paramas, String[] valuses) {
        if (paramas.length > valuses.length) {
            System.out.println("value number is less than param number");
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 1; i < paramas.length; i++) {
            if (paramas[i] != "") {
                map.put(paramas[i], valuses[i]);
            }
        }
        return map;
    }
}
