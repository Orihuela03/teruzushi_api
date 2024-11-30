package com.example.teruzushi_project.controller;

import com.example.teruzushi_project.modelo.Tables;
import com.example.teruzushi_project.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teruzushiapi/tables")
public class TablesController {

    @Autowired
    private TablesService tablesService;

    @GetMapping
    public List<Tables> getTables() {
        return tablesService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tables> getTableById(@PathVariable int id) {
        Optional<Tables> tables = tablesService.getTablesById(id);
        return tables.map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tables addTables(@RequestBody Tables tables) {
        return tablesService.addTables(tables);
    }

    @PutMapping("/{id}")
    public Tables updateTables(@PathVariable int id, @RequestBody Tables updatedTables) {
        updatedTables.setId(id);
        return tablesService.addTables(updatedTables);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable int id) {
        tablesService.deleteTable(id);
    }

}
