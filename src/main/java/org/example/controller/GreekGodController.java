package org.example.controller;

import org.example.model.pojos.Bios;
import org.example.model.repositories.GreekGodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreekGodController {

    private static GreekGodRepository repository;

    @Autowired
    public GreekGodController(GreekGodRepository repository){
        this.repository = repository;
    }

    @GetMapping("/allEnglishNames")
    public List<String> findAllEnglishNames(){
        List<Bios> bios = repository.findAll();
        List<String> allEnglishNames = new ArrayList<>();
        for (Bios bio: bios) {
            allEnglishNames.add(bio.englishName().stripLeading());
        }
        return allEnglishNames;
    }
}

