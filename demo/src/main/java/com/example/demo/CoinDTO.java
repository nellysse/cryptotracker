package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

    @Data
    public class CoinDTO {
        private String id;
        private String symbol;
        private String name;
        private String image;
        @JsonProperty("current_price")
        private Double currentPrice;
        @JsonProperty("price_change_percentage_24h")
        private Double priceChange24h;
    }
