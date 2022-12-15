package com.example.examen.service;

import com.example.examen.entities.Projet;
import com.example.examen.entities.Sprint;
import com.example.examen.entities.User;
import com.example.examen.repository.SprintRepo;
import com.example.examen.repository.projetRepo;
import com.example.examen.repository.userRepo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class serviceImpl implements Iservice {
    @Autowired
    userRepo userRepo;
    @Autowired
    projetRepo projetRepo;
    @Autowired
    SprintRepo sprintRepo;

    @Override
    public User addUser(User user) {

        return userRepo.save(user);

    }

    @Override
    public Projet addProject(Projet projet) {
        Sprint sprint = saveSprint(projet);
        sprint.setProjet(projet);
        projetRepo.save(projet);
        return projet;
    }


    private Sprint saveSprint(Projet projet) {
        {
            Set<Sprint> sprints = (Set<Sprint>) projet.getSprints();
            for (Sprint sprint : sprints) {
                return sprintRepo.save(sprint);
            }
            return null;
        }

    }


    @Override
    public Void assignProjectToDevoloper(int projectId, int devId) {
        Projet e = projetRepo.findById(projectId).orElse(null);
        User u = userRepo.findById(devId).orElse(null);
        u.getProjet().add(e);
        projetRepo.save(e);
        return null;
    }

    @Override
    public void assignProjectToScrum(int projetId, String fName, String lName) {
       

            User u = (User) userRepo.FindUsernameandfname(fName,lName);
            Projet p = projetRepo.findById(projetId).orElse(null);
            u.getProjet().add(p);
           projetRepo.save(p);



        }






    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Projet project = projetRepo.findById(idProject).orElse(null);
        sprint.setProjet(project);
        sprintRepo.save(sprint);
    }
    @Override
    @Scheduled(cron = "*/30 * * * * *" )
    public void getProjectsCurrentSprints() {
        Date d = new Date(System.currentTimeMillis());
        List<Sprint> sprints = sprintRepo.ListSprintsInfADate(d);
        log.print("Listes des Sprints : ");
        for (Sprint s:sprints) {
            log.print("Sprint : Sprint Description : " +s.getDescription()+"\n Sprint startDate : "+s.getStartDate());
        }
    }

    @Override
    public List<Projet> getProjectsByScrumMaster(String fName, String Iname) {
        val u = (User) userRepo.FindUsernameandfname(fName, Iname);
        List<Projet > k = new ArrayList<>(u.getProjet());

        return k;


    }
    }


