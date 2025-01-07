package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.Discount;
import com.spring.henallux.javaProjectB3.model.OrderLine;
import com.spring.henallux.javaProjectB3.model.Product;
import com.spring.henallux.javaProjectB3.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineDAO implements OrderLineDataAccess {
    private final OrderLineRepository orderLineRepository;
    private final ProductDAO productDAO;
    private final ProviderConverter providerConverter;
    private DiscountDAO discountDAO;
    private PromoService promoService;

    @Autowired
    public OrderLineDAO(OrderLineRepository orderLineRepository, ProductDAO productDAO, DiscountDAO discountDAO, PromoService promoService, ProviderConverter providerConverter) {
        this.orderLineRepository = orderLineRepository;
        this.productDAO = productDAO;
        this.discountDAO = discountDAO;
        this.promoService = promoService;
        this.providerConverter = providerConverter;
    }

    public List<OrderLine> getOrderLinesByOrderId(Integer orderId) {
        List<OrderLineEntity> orderLineEntities = orderLineRepository.findAllByOrder_Id(orderId);
        List<OrderLine> orderLines = new ArrayList<>();
        for (OrderLineEntity entity : orderLineEntities) {
            OrderLine orderLine = providerConverter.orderLineEntityToOrderLineModel(entity);

            // Inclure les détails du produit
            Product product = productDAO.getProductById(entity.getProduct().getId());
            orderLine.setProduct(product);

            orderLines.add(orderLine);
        }
        return orderLines;
    }

    public OrderLine save(OrderLine orderLine) {
        Product product = orderLine.getProduct();
        Discount discount = discountDAO.findDiscountById(product.getDiscountId());

        double priceWithDiscount = product.getPrice();
        if (discount != null) {
            priceWithDiscount = promoService.promo(product.getPrice(), discount.getDiscountPercent());
        }

        orderLine.setPrice(priceWithDiscount); // Stocke le prix avec la réduction
        OrderLineEntity orderLineEntity = providerConverter.orderLineModelToOrderLineEntity(orderLine);
        orderLineEntity = orderLineRepository.save(orderLineEntity);
        return providerConverter.orderLineEntityToOrderLineModel(orderLineEntity);
    }
}