package com.microservice.inventory.services;

import com.microservice.inventory.entities.Inventory;

import java.util.List;

public interface IInventoryService {

    List<Inventory> findAllProducts();

    Inventory findById(long id);

    void save(Inventory inventory);
}
