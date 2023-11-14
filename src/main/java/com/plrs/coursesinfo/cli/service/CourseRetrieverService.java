package com.plrs.coursesinfo.cli.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CourseRetrieverService {
    private static final String PS_URL = "https://app.pluralsight.com/profile/data/author/%s/all-content";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String getCoursesFor(String authorId) {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(PS_URL.formatted(authorId)))
                .GET()
                .build();
        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Could not call Pluralsight API", e);
        }
    }
}
