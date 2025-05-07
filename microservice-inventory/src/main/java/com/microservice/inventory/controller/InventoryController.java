package com.microservice.inventory.controller;

import com.microservice.inventory.entities.Inventory;
import com.microservice.inventory.services.IInventoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveInventory(@RequestBody Inventory inventory) {
        inventoryService.save(inventory);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProducts() {
        return ResponseEntity.ok(inventoryService.findAllProducts());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryService.findById(id));
    }
}
