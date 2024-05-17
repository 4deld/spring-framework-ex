package com.example.example0516.lotto.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Getter
public class PurchaseRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_record_id")
    private Long id;

    @Column(name = "purchase_name")
    private String purchaserName;


    //@Column(name = "draw_number")
}
