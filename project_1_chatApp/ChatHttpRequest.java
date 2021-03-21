package autotests;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatHttpRequest {
    private HttpURLConnection connection;

    public HttpURLConnection getConnection() {
        return connection;
    }

    public void createPOSTRequest(String strUrl, String requestBody) {
        try {
            URL url = new URL(strUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/plain");
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.writeBytes(requestBody);
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public String getServerMessage() {
        StringBuilder response = new StringBuilder();
        try {
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
