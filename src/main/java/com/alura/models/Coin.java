package com.alura.models;

public record Coin(
        String base_code,
        String target_code,
        String conversion_rate,
        String conversion_result) {
}