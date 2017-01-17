package JDK_API_16;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by dreamyao on 2017/1/17.
 */
public class JsonAssert {
    public static void getJson(String json) {
        JSONObject jsonObj = JSON.parseObject(json);
        for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
            if ("JSONArray".equals(entry.getValue().getClass().getSimpleName())) {
                JSONArray jsonArray = JSON.parseArray(entry.getValue().toString());
                for (int i = 0; i < jsonArray.size(); i++) {
                    getJson(jsonArray.get(i).toString());
                }
            } else if ("JSONObject".equals(entry.getValue().getClass().getSimpleName())) {
                getJson(entry.getValue().toString());
            } else {
                System.out.print(entry.getKey().toString() + " : ");
                System.out.println(entry.getValue().toString());
            }
        }
    }
}
