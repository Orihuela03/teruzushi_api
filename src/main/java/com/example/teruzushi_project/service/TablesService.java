package com.example.teruzushi_project.service;

import com.example.teruzushi_project.modelo.Tables;
import com.example.teruzushi_project.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TablesService {

    @Autowired
    private TablesRepository tablesRepository;

    public List<Tables> getAllTables() {
        return tablesRepository.findAll();
    }

    public Optional<Tables> getTablesById(Integer id) {
        return tablesRepository.findById(id);
    }

    public Tables addTables(Tables tables) {
        return tablesRepository.save(tables);
    }

    public void deleteTable(Integer id) {
        tablesRepository.deleteById(id);
    }

    public Tables updateTables(Tables tables) {
        if (tablesRepository.findById(tables.getId()).isPresent()) {
            Tables updatedTables = tablesRepository.getById(tables.getId());
            updatedTables.setCapacity(tables.getCapacity());
            updatedTables.setRestaurant(tables.getRestaurant());
            return tablesRepository.save(updatedTables);
        }
        else{
            return null;
        }
    }

}
