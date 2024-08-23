package com.example.employeeimput.repositories;

import com.example.employeeimput.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet,Long> {
}
