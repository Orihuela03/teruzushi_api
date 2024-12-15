package com.example.teruzushi_project.controller;

import com.example.teruzushi_project.modelo.Tables;
import com.example.teruzushi_project.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TablesController {

    @Autowired
    private TablesService tablesService;

    @GetMapping
    public List<Tables> getAllTables() {
        return tablesService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tables> getTableById(@PathVariable Long id) {
        return tablesService.getTableById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tables> createTable(@RequestBody Tables table) {
        if (table.getRestaurant() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tablesService.saveTable(table));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tables> updateTable(@PathVariable Long id, @RequestBody Tables table) {
        return tablesService.getTableById(id).map(existing -> {
            existing.setCapacity(table.getCapacity());
            existing.setRestaurant(table.getRestaurant());
            tablesService.saveTable(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        if (tablesService.getTableById(id).isPresent()) {
            tablesService.deleteTable(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}