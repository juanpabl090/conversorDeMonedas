package com.alura.controller;

import com.alura.models.Coin;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PairConversionRequestController {

    public Coin Pairconvert(String base_code, String target_code, String amount) {
        String encodeBrowser =
                String.format("https://v6.exchangerate-api.com/v6/c7e77f1ce587d483f7ca80ce/pair/%s/%s/%s",
                        base_code, target_code, amount);
        URI direction = URI.create(encodeBrowser);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direction).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed to retrieve exchange rate. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error sending request: " + e.getMessage());
        }
        assert response != null;
        return new Gson().fromJson(response.body(), Coin.class);
    }
}