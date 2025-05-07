package com.microservice.inventory.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor

public class Inventory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name =  "product_name")
    private String productName;
    private int quantity;
    private String description;
}
