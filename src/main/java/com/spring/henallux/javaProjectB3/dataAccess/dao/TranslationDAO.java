package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.dataAccess.entity.TranslationEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.TranslationRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationDAO implements TranslationDataAccess {
    private TranslationRepository translationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationDAO(TranslationRepository productCategoryRepository, ProviderConverter providerConverter) {
        this.translationRepository = productCategoryRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<ProductCategory> getTranslationsByLanguage(String language) {
        List<TranslationEntity> result = translationRepository.findByLanguageName(language);

        ArrayList<ProductCategory> categories = new ArrayList<>();
        for (TranslationEntity entity : result) {
            ProductCategory category = providerConverter.productCategoryEntityToProductCategoryModel(entity.getCategory());
            category.setName(entity.getName());  // Utiliser le nom traduit
            categories.add(category);
        }
        return categories;
    }
}
