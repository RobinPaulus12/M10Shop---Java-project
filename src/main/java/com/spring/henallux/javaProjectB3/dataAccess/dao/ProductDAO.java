package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.dataAccess.entity.ProductEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.ProductRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO implements ProductDataAccess {
    private ProviderConverter providerConverter;
    private ProductRepository productRepository;

    @Autowired
    public ProductDAO(ProviderConverter providerConverter, ProductRepository productRepository) {
        this.providerConverter = providerConverter;
        this.productRepository = productRepository;

    }

    public ArrayList<Product> getAllProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();

        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity entity : productEntityList) {
            products.add(providerConverter.productEntityToProductModel(entity));
        }

        return products;

    }

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(providerConverter::productEntityToProductModel)
                .orElse(null);
    }

    @Override
    public ArrayList<Product> findByCategoryId(Integer category) {
        List<ProductEntity> productEntityList = productRepository.findByCategoryId(category);

        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity entity : productEntityList) {
            products.add(providerConverter.productEntityToProductModel(entity));
        }

        return products;

    }

    @Override
    public Product findAllById (Integer product) {
        ProductEntity productEntities = productRepository.findAllById(product);
        return  providerConverter.productEntityToProductModel(productEntities);
    }
}
