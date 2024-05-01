package com.conversor.network;

import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientSingleton {
    private static HttpClient instance = null;

    private HttpClientSingleton() {
    }

    public static HttpClient getInstance() {
        if (instance == null) {
            instance = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();
        }
        return instance;
    }

}
