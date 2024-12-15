package com.example.teruzushi_project.repository;

import com.example.teruzushi_project.modelo.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {
}