package com.example.examen.service;

import com.example.examen.entities.Projet;
import com.example.examen.entities.Sprint;
import com.example.examen.entities.User;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface Iservice {

    User addUser(User user);

    Projet addProject(Projet projet);

    Void assignProjectToDevoloper(int projectId, int devId);



    void assignProjectToScrum(int projectId, String fName, String lName);

    void addSprintAndAssignToProject(Sprint sprint, int idProject);

    @Scheduled(cron = "*/30 * * * * *" )
    void getProjectsCurrentSprints();

    List<Projet> getProjectsByScrumMaster(String fName, String Iname);
}
