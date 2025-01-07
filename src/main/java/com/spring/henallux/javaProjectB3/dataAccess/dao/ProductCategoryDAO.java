package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.dataAccess.entity.ProductCategoryEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.ProductCategoryRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryDAO implements ProductCategoryDataAccess {
    private final ProviderConverter providerConverter;
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryDAO(ProviderConverter providerConverter, ProductCategoryRepository productCategoryRepository) {
        this.providerConverter = providerConverter;
        this.productCategoryRepository = productCategoryRepository;

    }

    @Override
    public ProductCategory findAllById (Integer id) {
        ProductCategoryEntity productCategoryEntities = productCategoryRepository.findAllById(id);
        return  providerConverter.productCategoryEntityToProductCategoryModel(productCategoryEntities);
    }

    public ArrayList<ProductCategory> findAll() {
        List<ProductCategoryEntity> productCategoryEntities = productCategoryRepository.findAll();
        ArrayList<ProductCategory> productCategories = new ArrayList<>();

        for(ProductCategoryEntity entity : productCategoryEntities) {
            productCategories.add(providerConverter.productCategoryEntityToProductCategoryModel(entity));

        }
        return  productCategories;
    }

    @Override
    public ProductCategory findAllByName(String categoryName) {
        ProductCategoryEntity productCategoryEntities = productCategoryRepository.findAllByName(categoryName);
        return  providerConverter.productCategoryEntityToProductCategoryModel(productCategoryEntities);
    }

    @Override
    public ProductCategory findByTranslatedName(String name,String language) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findByTranslatedName(name,language);
        return providerConverter.productCategoryEntityToProductCategoryModel(productCategoryEntity);
    }

    public ProductCategory findByName(String name) {
        ProductCategoryEntity categoryEntity = productCategoryRepository.findAllByName(name);
        if (categoryEntity != null) {
            return providerConverter.productCategoryEntityToProductCategoryModel(categoryEntity);
        }
        return null;
    }
}
