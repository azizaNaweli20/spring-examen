package com.example.examen.controller;


import com.example.examen.entities.Projet;
import com.example.examen.entities.User;
import com.example.examen.repository.userRepo;
import com.example.examen.service.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class testController {
    Iservice iservice;

        @GetMapping("/Adduser")
        @ResponseBody
        public  User addUser (@RequestBody User user){
                return iservice.addUser(user);
            }

    @GetMapping("/Addprojet")
    @ResponseBody
    public Projet addProject(Projet projet) {
        return iservice.addProject(projet);
    }


    @PostMapping("/assignProjectToDevoloper/{projectId}/{devId}")
    public void assignProjectToDevoloper (@PathVariable("projectId")int projectId, @PathVariable("devId") int devId) {
        iservice.assignProjectToDevoloper(projectId,devId);

    }

    @PostMapping("/assignProjectToScrumMaster /{projectId}/{FName}/{LName}")
    public void assignProjectToScrumMaster (@PathVariable("projectId")int projectId, @PathVariable("FName") String FName,@PathVariable("LName") String LName) {
        iservice.assignProjectToScrum(projectId,LName,FName);

    }
    @GetMapping("/allprojects/{fName}/{IName}")
    public List<Projet> getProjectsByScrumMaster( @PathVariable  String fName,@PathVariable  String IName ){

        return  userRepo.getProjectsByScrumMaster(fName,IName);
    }



    }


