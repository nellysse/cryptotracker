package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
@CrossOrigin(origins = "*")
public class CoinController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://api.coingecko.com/api/v3";

    @GetMapping("/markets")
    public List<Object> getMarkets() {
        String url = BASE_URL + "/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1";
        return restTemplate.getForObject(url, List.class);
    }

    @GetMapping("/{id}")
    public Object getCoinData(@PathVariable String id) {
        String url = BASE_URL + "/coins/" + id + "?localization=false&market_data=true";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/{id}/chart")
    public Object getChartData(@PathVariable String id) {
        String url = BASE_URL + "/coins/" + id + "/market_chart?vs_currency=usd&days=7";
        return restTemplate.getForObject(url, Object.class);
    }
}