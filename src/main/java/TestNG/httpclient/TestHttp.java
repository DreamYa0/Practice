package TestNG.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHttpResponse;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by DreamYao on 2016/5/21.
 */
public class TestHttp {
    public static void main(String[] args) {
        URI url = null;
        try {
            url = new URIBuilder().setScheme("http").setHost("www.baidu.com").setPath("/search").setParameter("q", "httpclient").setParameter("btnG", "baidu Search").setParameter("aq", "f").setParameter("oq", "").build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpGet httpGet = new HttpGet(url);
        System.out.print(httpGet.getURI());
        System.out.println();
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        response.addHeader("Set-Cookie", "c1=a; path=/; domain=localhost");
        response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        System.out.println();
        Header h2=response.getLastHeader("Set-Cookie");
        System.out.println(h2);
        System.out.println();
        Header[] hs=response.getHeaders("Set-Cookie");
        System.out.println(hs.length);
        System.out.println();
        System.out.print(response.getProtocolVersion());
        System.out.println();
        System.out.print(response.getStatusLine().getStatusCode());
        System.out.println();
        System.out.print(response.getStatusLine().getReasonPhrase());
        System.out.println();
        System.out.print(response.getStatusLine().toString());
    }
}
