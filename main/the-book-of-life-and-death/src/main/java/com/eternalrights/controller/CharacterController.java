package com.eternalrights.controller;

import com.eternalrights.pojo.characters;
import com.eternalrights.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @RequestMapping("/characters")
    public List<characters> findAll(){
        List<characters> charactersList = characterService.findAll();
        return charactersList;
    }
}
