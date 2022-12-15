package com.example.examen.repository;

import com.example.examen.entities.Projet;
import com.example.examen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projetRepo extends JpaRepository<Projet,Integer> {
}
