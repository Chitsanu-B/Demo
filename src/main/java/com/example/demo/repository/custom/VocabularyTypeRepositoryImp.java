package com.example.demo.repository.custom;

import com.example.demo.enity.VocabularyType;
import com.example.demo.repository.VocabularyTypeRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VocabularyTypeRepositoryImp implements VocabularyTypeRepositoryCustom{

    @Autowired
    private VocabularyTypeRepository vocabularyTypeRepository;

    public Map save(String dataJson){
        try {

            JSONObject jsonObject = new JSONObject(dataJson);
            VocabularyType vocabularyType = new VocabularyType();

            vocabularyType.setShortType(jsonObject.getString("shortType"));
            vocabularyType.setTypeDescriptionTh(jsonObject.getString("typeDescriptionTh"));
            vocabularyType.setTypeMeaningTh(jsonObject.getString("typeMeaningTh"));
            vocabularyType.setTypeName(jsonObject.getString("typeName"));
            vocabularyType.setVersion(jsonObject.getLong("version"));

            vocabularyTypeRepository.saveAndFlush(vocabularyType);
            Map map = new HashMap();
            map.put("id", vocabularyType.getId());
            map.put("imageFile", vocabularyType.getShortType());
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map update(String dataJson) {
        try{
            JSONObject jsonObject = new JSONObject(dataJson);
            Long id = jsonObject.optLong("id", 0);//Get ID
            VocabularyType vocabularyType;
            if(id>0){
                vocabularyType = vocabularyTypeRepository.getOne(id);

            }else{
                vocabularyType = new VocabularyType();
            }

            vocabularyType.setShortType(jsonObject.getString("shortType"));
            vocabularyType.setTypeDescriptionTh(jsonObject.getString("typeDescriptionTh"));
            vocabularyType.setTypeMeaningTh(jsonObject.getString("typeMeaningTh"));
            vocabularyType.setTypeName(jsonObject.getString("typeName"));
            vocabularyType.setVersion(jsonObject.getLong("version"));

            vocabularyTypeRepository.saveAndFlush(vocabularyType);
            Map map = new HashMap();
            map.put("id", vocabularyType.getId());
            map.put("imageFile", vocabularyType.getShortType());
            return map;
        }catch (Exception e){
        e.printStackTrace();
        return null;
        }
    }

    @Override
    public List<VocabularyType> saveByList(String dataJson) {
        JSONArray jsonArray = new JSONArray(dataJson);

        List<VocabularyType> voc = new ArrayList<>();
        for(int i = 0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            VocabularyType vocabularyType = new VocabularyType();

            vocabularyType.setShortType(jsonObject.getString("shortType"));
            vocabularyType.setTypeDescriptionTh(jsonObject.getString("typeDescriptionTh"));
            vocabularyType.setTypeMeaningTh(jsonObject.getString("typeMeaningTh"));
            vocabularyType.setTypeName(jsonObject.getString("typeName"));
            vocabularyType.setVersion(jsonObject.getLong("version"));

            vocabularyTypeRepository.saveAndFlush(vocabularyType);
            voc.add(vocabularyType);
        }

      return voc;
    }

    @Override
    public VocabularyType findByID(Long id) {

        return vocabularyTypeRepository.getOne(id);
    }
}
