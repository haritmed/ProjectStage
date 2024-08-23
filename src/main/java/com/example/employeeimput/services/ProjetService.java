package com.example.employeeimput.services;

import com.example.employeeimput.entities.Manager;
import com.example.employeeimput.entities.Projet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjetService {
    Projet saveProjet(Projet projet);
    Projet updateProjet(Projet projet);//"Update"
    void deleteProjetById(Long id);//"Delete by id"
    void deleteAllProjet();//"Delete All"
    Projet getProjetById(Long id); //"Read by id"
    List<Projet> getAllProjet();
    Page<Projet> getAllProjetByPage(int page, int size);
}
