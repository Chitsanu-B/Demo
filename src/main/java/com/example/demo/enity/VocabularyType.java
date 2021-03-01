package com.example.demo.enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class VocabularyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long version;

    private String shortType;

    private String typeName;

    private String typeMeaningTh;

    private String TypeDescriptionTh;
}



