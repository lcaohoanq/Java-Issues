package com.lcaohoanq;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GitHubRepoChecker {

    static String publicRepo = "https://github.com/lcaohoanq/Git-Clone-App";
    static String privateRepo = Dotenv.configure().load().get("PRIVATE_REPO");

    public static void main(String[] args) {
        String repoUrl = privateRepo;
        try {
            boolean isPublic = isPublicRepository(repoUrl);
            if (isPublic) {
                System.out.println("The repository is public.");
            } else {
                System.out.println("The repository is private.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPublicRepository(String repoUrl) throws Exception {
        String apiUrl = convertToApiUrl(repoUrl);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiUrl);
        request.addHeader("Authorization", "token " + Dotenv.configure().load().get("GITHUB_TOKEN"));
        // Optional: add your GitHub token here if you want to access private repositories
        // request.addHeader("Authorization", "token YOUR_GITHUB_TOKEN");

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(jsonResponse);
            System.out.println(jsonObject);
            return !jsonObject.getBoolean("private");
        } else if (statusCode == 404) {
            throw new Exception("Repository not found");
        } else {
            throw new Exception("Failed to fetch repository details");
        }
    }

    private static String convertToApiUrl(String repoUrl) {
        // Extract the path from the URL and construct the API URL
        String path = repoUrl.replace("https://github.com/", "");
        return "https://api.github.com/repos/" + path;
    }
}