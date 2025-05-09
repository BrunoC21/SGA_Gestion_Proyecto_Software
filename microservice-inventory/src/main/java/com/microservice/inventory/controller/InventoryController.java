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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long id) {
        Inventory existingInventory = inventoryService.findById(id);
        if (existingInventory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inventory with ID " + id + " not found");
        }

        inventoryService.deleteById(id);
        return ResponseEntity.ok("Inventory with ID " + id + " deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable Long id, @RequestBody Inventory inventoryDetails) {
        Inventory existingInventory = inventoryService.findById(id);
        if (existingInventory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inventory with ID " + id + " not found");
        }

        // Actualizo solo los atributos que vienen en la request
        existingInventory.setProductName(inventoryDetails.getProductName());
        existingInventory.setQuantity(inventoryDetails.getQuantity());
        existingInventory.setDescription(inventoryDetails.getDescription());

        inventoryService.save(existingInventory);  // save hace UPDATE porque ya tiene id

        return ResponseEntity.ok(existingInventory);
    }
}