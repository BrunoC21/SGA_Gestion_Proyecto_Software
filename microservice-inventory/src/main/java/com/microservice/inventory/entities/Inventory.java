package com.microservice.inventory.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


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

    @ManyToOne
    private Products product;

    @Column(name = "numero_lote")
    private String inventoryNumber;

    @Column(name = "fecha_vencimiento")
    private LocalDate expDate;

    @Column(name = "precio_unitario")
    private Double unitPrice;
}
