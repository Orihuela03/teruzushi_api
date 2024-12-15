package com.example.teruzushi_project.service;

import com.example.teruzushi_project.modelo.Tables;
import com.example.teruzushi_project.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesService {

    @Autowired
    private TablesRepository tablesRepository;

    public List<Tables> getAllTables() {
        return tablesRepository.findAll();
    }

    public Optional<Tables> getTableById(Long id) {
        return tablesRepository.findById(id);
    }

    public Tables saveTable(Tables table) {
        return tablesRepository.save(table);
    }

    public void deleteTable(Long id) {
        tablesRepository.deleteById(id);
    }
}