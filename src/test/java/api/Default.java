package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Default {
    public static void main(String args[])
    {
        makeAPICall();
    }
    public static String makeAPICall() {
        try {

            String apiUrl = "https://jsonplaceholder.typicode.com/posts";
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String outputLine;
            StringBuilder outputData = new StringBuilder();
            while ((outputLine = br.readLine()) != null) {
                outputData.append(outputLine);
            }
            System.out.println(outputData.toString());
            conn.disconnect();
            return outputData.toString();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
}
