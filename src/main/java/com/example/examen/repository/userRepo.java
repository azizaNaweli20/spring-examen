package com.example.examen.repository;

import com.example.examen.entities.Projet;
import com.example.examen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface userRepo  extends JpaRepository<User,Integer> {


    static List<Projet> getProjectsByScrumMaster(String fName, String iName) {
        return null;
    }


    Object FindUsernameandfname(String fName, String iname);
}
