package com.example.examen.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String email;
    private String pwd;
    private String FName;
    private String IName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany
    private Set<Projet> projet;
    @ManyToMany
    private Set<Projet>projets;


}
