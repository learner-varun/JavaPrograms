package api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppacheHTTPClient {
    public static void main(String arg[])
    {
        callGetAPI();
    }

public static void callGetAPI() {
    try {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String exampleAPIURL = "https://jsonplaceholder.typicode.com/posts";
        HttpGet httpGet = new HttpGet(exampleAPIURL);
        httpGet.addHeader("User-Agent", "test");
       httpGet.removeHeaders("User-Agent");
     //   System.out.println( httpGet.getFirstHeader("User-Agent").getValue());
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        System.out.println("GET Response Status:: "
                + httpResponse.getStatusLine().getStatusCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        // print result
        System.out.println(response.toString());
        httpClient.close();
    }catch (Exception e)
    {

    }
}
}
