package com.example.demo.repository.custom;

import com.example.demo.enity.VocabularyType;

import java.util.List;
import java.util.Map;

public interface VocabularyTypeRepositoryCustom {
    Map save(String dataJson);

    Map update(String dataJson);

    List<VocabularyType> saveByList(String dataJson);

    VocabularyType findByID(Long id);

}
