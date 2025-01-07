package com.spring.henallux.javaProjectB3.dataAccess.repository;

import com.spring.henallux.javaProjectB3.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
    List<TranslationEntity> findByLanguageName(String language);
}
