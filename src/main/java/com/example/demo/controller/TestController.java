package com.example.demo.controller;

import com.example.demo.repository.VocabularyTypeRepository;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    VocabularyTypeRepository vocabularyTypeRepository;

    @GetMapping("/")
    public String test001(){
        return new JSONSerializer().exclude("*.class").serialize(vocabularyTypeRepository.findAll());
    }

    @GetMapping("/{id}")
    public String testFindById(@PathVariable("id") Long id){
        return new JSONSerializer().exclude("*.class").serialize(vocabularyTypeRepository.getOne(id));
    }

    @PostMapping
    public String save(@RequestBody String dataJson){
        return "OK";
    }


    @GetMapping("/test2")
    public ResponseEntity<String> test002(){
        return new ResponseEntity<>(new JSONSerializer().exclude("*.class").serialize(vocabularyTypeRepository.findAll()), HttpStatus.OK);
    }


}
