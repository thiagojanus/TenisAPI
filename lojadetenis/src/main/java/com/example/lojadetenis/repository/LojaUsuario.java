package com.example.lojadetenis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lojadetenis.model.Lojadetenis;

public interface LojaUsuarioRepository extends JpaRepository<Lojadetenis, Long>{
    Lojadetenis findById(long Id);    
}