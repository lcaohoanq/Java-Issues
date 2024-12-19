package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java11;

import com.fasterxml.jackson.databind.ObjectWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyHttpClient {


    public static void main(String[] args) throws Exception {
        // Tạo đối tượng HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Tạo đối tượng HttpRequest sử dụng Builder
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://6512cbd2b8c6ce52b3963937.mockapi.io/users"))
            .GET() //default is GET request
            .build();

        // Gửi HTTP request và nhận HTTP response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // In thông tin về HTTP response
        System.out.println("Response Code: " + response.statusCode());

        //In thông tin về HTTP response body
        //System.out.println("Response Body: " + response.body());
        //Response Body: [{"name":"Hoàng cờ hó","yob":"1968-09-04T14:32:11.986Z","id":"2"},{"name":"Inez Runolfsdottir","yob":"1998-04-04T00:03:30.055Z","id":"3"},{"name":"Scott Tromp","yob":"2000-10-14T22:54:41.761Z","id":"4"},{"name":"Mamie Beatty","yob":"1993-08-04T02:30:05.060Z","id":"5"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"6"},{"name":"Linh xe ôm","yob":2001,"id":"9"},{"name":"Linh xe ôm","yob":2001,"id":"10"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"11"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"12"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"13"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"14"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"15"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"16"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"17"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"18"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"19"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"20"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"21"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"22"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"23"},{"name":"Em Điệp Đệ Quy","yob":2004,"id":"24"},{"name":"Mr. Karl Collier","yob":"1965-10-29T05:55:07.260Z","id":"25"},{"name":"Victoria Konopelski I","yob":"1973-05-18T10:15:25.819Z","id":"26"},{"name":"Angie Towne","yob":"1974-04-30T19:48:45.965Z","id":"27"},{"name":"Sheldon Johnson","yob":"1980-12-12T07:46:54.932Z","id":"28"},{"name":"Johnathan Bogisich","yob":"1990-04-27T22:21:34.254Z","id":"29"},{"name":"Shari Bogan","yob":"1958-07-01T23:54:54.033Z","id":"30"},{"name":"ke bi an 2","yob":"1949-02-24T21:27:35.151Z","id":"31"},{"name":"ke bi an","yob":"1982-06-27T09:02:08.234Z","id":"32"}]
        ObjectMapper mapper = new ObjectMapper();
        Object json = mapper.readValue(response.body(), Object.class);
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String prettyJson = writer.writeValueAsString(json);

        System.out.println("Response Body: " +prettyJson);

        // In thông tin về HTTP response headers
        response.headers().map().forEach((k, v) -> System.out.println(k + ":" + v));

    }

}
