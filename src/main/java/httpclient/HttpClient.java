package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by DreamYao on 2016/6/16.
 */
public class HttpClient {
    private static HttpPost post;
    private static HttpGet get;
    private static CloseableHttpResponse response;
    public static String responseContent;

    public HttpClient(){}

    public static String sendInfo(CloseableHttpClient client, String sendurl, String data) {
        post = new HttpPost(sendurl);
        StringEntity myEntity = new StringEntity(data, ContentType.APPLICATION_JSON);// 构造请求数据实体对象
        post.setEntity(myEntity);// 设置请求体
         // 响应内容
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseContent = verification(response);
        return responseContent;
    }

    public static String sendInfo(CloseableHttpClient client, String sendurl) {
        get = new HttpGet(sendurl);
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseContent = verification(response);
        return responseContent;
    }
    public static String sendInfo(CloseableHttpClient client,String sendurl, String data,List<NameValuePair> postForm) {
        post = new HttpPost(sendurl);
        if(postForm != null){
            try {
                post.setEntity(new UrlEncodedFormEntity(postForm ));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            post.setEntity(new StringEntity(data,ContentType.APPLICATION_JSON));// 设置JSON请求体
        }
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseContent = verification(response);
        return responseContent;
    }

    /**
     * 处理返回结果
     * @param response
     * @return
     */
    private static String verification(CloseableHttpResponse response){
        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return responseContent;
    }

}
