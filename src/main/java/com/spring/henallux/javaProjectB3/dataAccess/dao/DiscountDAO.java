package com.spring.henallux.javaProjectB3.dataAccess.dao;


import com.spring.henallux.javaProjectB3.dataAccess.entity.DiscountEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.DiscountRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountDAO implements DiscountDataAccess{
    private final ProviderConverter providerConverter;

    private DiscountRepository discountRepository;

    @Autowired
    public DiscountDAO(ProviderConverter providerConverter, DiscountRepository discountRepository) {
        this.providerConverter = providerConverter;
        this.discountRepository = discountRepository;
    }

    @Override
    public Discount findDiscountById (Integer id) {
        DiscountEntity discountEntity = discountRepository.findDiscountById(id);
        return providerConverter.discountEntityToDiscountModel(discountEntity);
    }


}
