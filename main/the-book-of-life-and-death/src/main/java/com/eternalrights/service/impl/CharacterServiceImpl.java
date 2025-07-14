package com.eternalrights.service.impl;

import com.eternalrights.dao.CharacterDao;
import com.eternalrights.pojo.characters;
import com.eternalrights.service.CharacterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterDao characterDao;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<characters> findAll() {
        List<String> jsonLines = characterDao.findAll();
        List<characters> cs = new ArrayList<>();

        for (String json : jsonLines) {
            try {
                characters character = objectMapper.readValue(json, characters.class);
                cs.add(character);
            } catch (Exception e) {
                throw new RuntimeException("JSON解析失败: " + json, e);
            }
        }
        return cs;
    }
}