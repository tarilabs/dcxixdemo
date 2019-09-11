package dcxixdemo.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

    private HttpUtils() {
        // no init for utility class.
    }

    public static String post(String path, String body) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost:8090/" + path);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(new StringEntity(body));
            CloseableHttpResponse response = client.execute(httpPost);
            String responseResult = EntityUtils.toString(response.getEntity());
            client.close();
            return responseResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
