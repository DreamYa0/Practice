package restassured;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;

import java.io.InputStream;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/8/12 14:54
 */
public class TestGet {

    public static void main(String[] args) {
        given().param("x", "y")
                .header("z", "w")
                .when().get("/something").then().statusCode(200)
                .body("x.y", equalTo("z"));

        InputStream stream = get("/lotto").asInputStream();
        byte[] bytes = get("/lotto").asByteArray();
        String json = get("/lotto").asString();

        //想验证内容类型是JSON格式且标题是My Title，但是还想要从中提取next的值并用来发起请求
        String nextTitleLink = given().param("param_name", "param_value")
                .when().get("/title").then().contentType(JSON)
                .body("title", equalTo("My Title"))
                .extract().path("_links.next.href");

        //如果您想提取多个值，也可以考虑返回整个响应体
        Response response =
                given().
                        param("param_name", "param_value").
                        when().
                        get("/title").
                        then().
                        contentType(JSON).
                        body("title", equalTo("My Title")).
                        extract().
                        response();

        String titleLink = response.path("_links.next.href");
        String headerValue = response.header("headerName");

        //一旦我们取得了响应体，可以使用JsonPath来提取相应的数据
        int lottoId=from(json).getInt("lotto.lottoId");
        List<Integer> winnerIds = from(json).get("lotto.winners.winnerId");

        //或者更高效一些
        JsonPath jsonPath = new JsonPath(json).setRoot("lotto");
        int lottoId1 = jsonPath.getInt("lottoId");
        List<Integer> winnerIds1 = jsonPath.get("winners.winnderId");

        //您可以为JsonPath配置反序列化对象（object de-serializers)
        JsonPath jsonPath1 = new JsonPath("SOME_JSON").using(new JsonPathConfig("UTF-8"));

        //也可以静态配置好JsonPath，这样所有的JsonPath实例都会共享这个配置
        JsonPath.config = new JsonPathConfig("UTF-8");
    }
}
