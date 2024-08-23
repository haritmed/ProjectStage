package com.example.employeeimput.services;

import com.example.employeeimput.entities.Projet;

import com.example.employeeimput.repositories.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProjetServiceImp implements ProjetService {
    @Autowired
    private ProjetRepository projetRepository;
    @Override
    public Projet saveProjet(Projet manager) {
        return projetRepository.save(manager);
    }

    @Override
    public Projet updateProjet(Projet manager) {
        return projetRepository.save(manager);
    }

    @Override
    public void deleteProjetById(Long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public void deleteAllProjet() {
        projetRepository.deleteAll();
    }

    @Override
    public Projet getProjetById(Long id) {
        return projetRepository.findById(id).get();
    }

    @Override
    public List<Projet> getAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Page<Projet> getAllProjetByPage(int page, int size) {
        return projetRepository.findAll(PageRequest.of(page, size));
    }
}
