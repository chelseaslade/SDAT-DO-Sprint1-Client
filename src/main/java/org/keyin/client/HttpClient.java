package org.keyin.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    // Generic method to send GET request
    public static String sendGetRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        return responseCode == 200 ? readResponse(conn) : "GET Request Failed: " + responseCode;
    }

    // Generic method to send POST request
    public static String sendPostRequest(String apiUrl, String jsonInput) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes("utf-8"));
        }

        int responseCode = conn.getResponseCode();
        return responseCode == 201 ? readResponse(conn) : "POST Request Failed: " + responseCode;
    }

    // Generic method to send PUT request
    public static String sendPutRequest(String apiUrl, String jsonInput) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes("utf-8"));
        }

        int responseCode = conn.getResponseCode();
        return responseCode == 200 ? readResponse(conn) : "PUT Request Failed: " + responseCode;
    }

    // Generic method to send DELETE request
    public static String sendDeleteRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");

        int responseCode = conn.getResponseCode();
        return responseCode == 200 ? "Deleted Successfully" : "DELETE Request Failed: " + responseCode;
    }

    // Helper method to read response
    private static String readResponse(HttpURLConnection conn) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }
    }
}
