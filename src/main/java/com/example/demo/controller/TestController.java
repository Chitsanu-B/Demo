package com.example.demo.controller;

import com.example.demo.repository.VocabularyTypeRepository;
import com.example.demo.repository.custom.VocabularyTypeRepositoryCustom;
import com.example.demo.repository.custom.VocabularyTypeRepositoryImp;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    VocabularyTypeRepository vocabularyTypeRepository;

    @Autowired
    VocabularyTypeRepositoryCustom vocabularyTypeRepositoryCustom;

    @GetMapping("/")
    public String test001(){
        return new JSONSerializer().exclude("*.class").serialize(vocabularyTypeRepository.findAll());
    }

    @GetMapping("/{id}")
    public String testFindById(@PathVariable("id") Long id){
        return new JSONSerializer().exclude("*.class").serialize(vocabularyTypeRepositoryCustom.findByID(id));
    }

    @PostMapping
    public String save(@RequestBody String dataJson){
        return new JSONSerializer().serialize(vocabularyTypeRepositoryCustom.save(dataJson));
    }


    @GetMapping("/test2")
    public ResponseEntity<String> test002(){
        return new ResponseEntity<>(new JSONSerializer().exclude("*.class").serialize(vocabularyTypeRepository.findAll()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        vocabularyTypeRepository.deleteById(id);
    }




}
