package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class HistoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coinId;
    private LocalDateTime viewTime;
    public HistoryItem() {}

    public HistoryItem(String coinId, LocalDateTime viewTime) {
        this.coinId = coinId;
        this.viewTime = viewTime;
    }
}