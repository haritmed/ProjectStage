package com.example.employeeimput.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="projet")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double budgetTotal;
    private Integer heuresAllouees;

    @ManyToOne
    private Administrateur administrateur;

    @ManyToOne
    private Manager manager;

    @OneToMany(mappedBy = "projet")
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "projet")
    private List<LotProjet> lotprojets=new ArrayList<>();


}