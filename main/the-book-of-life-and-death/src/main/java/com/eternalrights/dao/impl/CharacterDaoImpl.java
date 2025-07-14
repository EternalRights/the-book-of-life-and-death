package com.eternalrights.dao.impl;

import com.eternalrights.dao.CharacterDao;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Repository;

import static java.lang.System.in;

@Repository
public class CharacterDaoImpl implements CharacterDao {
    @Override
    public ArrayList<String> findAll(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("characters.txt");
        ArrayList<String> lines = IoUtil.readLines(inputStream, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}