package TestNG.Jsoup;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by dreamyao on 16-9-19.
 */
public class VerificationUtil extends HttpClient{
    public static void Test(CloseableHttpResponse response){
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
    }
}
