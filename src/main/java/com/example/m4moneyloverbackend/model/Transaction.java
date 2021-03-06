package com.example.m4moneyloverbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "vi_VN", timezone = "Asia/Ho_Chi_Minh")
    private Date date;
    private String file;
    @ManyToOne(targetEntity = Wallet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Transaction(String name, double amount, Date date, Wallet wallet) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.wallet = wallet;
    }
}