package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java9;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHTTPClient {
    public static void main(String[] args) throws Exception {
        // Tạo đối tượng HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Tạo đối tượng HttpRequest sử dụng Builder
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(new URI("https://www.youtube.com"))
            .GET()
            .build();

        // Gửi HTTP request và nhận HTTP response
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // In thông tin về HTTP response
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }
}

