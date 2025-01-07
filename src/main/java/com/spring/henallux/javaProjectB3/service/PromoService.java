package com.spring.henallux.javaProjectB3.service;


import org.springframework.stereotype.Service;

@Service
public class PromoService {
    public Double promo(Double price,Double discount) {
          return price - (price * discount);
    }
}
