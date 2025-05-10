package com.microservice.inventory.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stock_bodega")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockWare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Inventory lot;

}
