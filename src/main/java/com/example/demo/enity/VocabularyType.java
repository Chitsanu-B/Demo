package com.example.demo.enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class VocabularyType {

    @Id
    private Long id;


    private Long version;

    private String createdBy;


    private Date createdDate;

    private String updatedBy;


    private Date updatedDate;

    private String shortType;

    private String typeName;

    private String typeMeaningTh;

    private String TypeDescriptionTh;
}



