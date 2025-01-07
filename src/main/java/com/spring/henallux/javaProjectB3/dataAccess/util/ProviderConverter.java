package com.spring.henallux.javaProjectB3.dataAccess.util;

import com.spring.henallux.javaProjectB3.dataAccess.entity.*;
import com.spring.henallux.javaProjectB3.model.*;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {
    private Mapper mapper = new DozerBeanMapper();


    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        //userEntity.setId(user.getId());
        //userEntity.setDateOfBirth(user.getDateOfBirth()); // Mapper manuellement
        userEntity.setAccountNonExpired(user.getAccountNonExpired());
        userEntity.setAccountNonLocked(user.getAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.getCredentialsNonExpired());
        userEntity.setEnabled(user.getEnabled());
        userEntity.setAuthorities(user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority) // Extrait les noms des rôles
                .reduce((a, b) -> a + "," + b)       // Concatène les rôles avec une virgule
                .orElse(""));                        // Définit une chaîne vide si la collection est vide

        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        //user.setDateOfBirth(userEntity.getDateOfBirth());
        //user.setId(userEntity.getId());
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setAuthorities(userEntity.getAuthorities());
        return user;
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = mapper.map(order, OrderEntity.class);
        orderEntity.setPaid(order.getIsPaid());
        return orderEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = mapper.map(orderEntity, Order.class);
        order.setIsPaid(orderEntity.getPaid());
        return order;
    }

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = mapper.map(orderLine, OrderLineEntity.class);
        if (orderLine.getOrderId() != null) {
            OrderEntity orderEntity = orderModelToOrderEntity(orderLine.getOrderId());
            orderLineEntity.setOrder(orderEntity);
        }
        orderLineEntity.setPrice(orderLine.getPrice()); // Assurez-vous que ce prix est le total.
        return orderLineEntity;
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {
        OrderLine orderLine = mapper.map(orderLineEntity, OrderLine.class);
        return orderLine;
    }

    public ProductEntity productModelToProductEntity(Product product) {
        ProductEntity productEntity = mapper.map(product, ProductEntity.class);
        return productEntity;
    }

    public Product productEntityToProductModel(ProductEntity productEntity) {
        Product product = mapper.map(productEntity, Product.class);
        product.setCategoryId(productEntity.getCategory().getId());

        if (productEntity.getDiscount() != null) {
            product.setDiscountId(productEntity.getDiscount().getId());
        } else {
            product.setDiscountId(null); // Valeur par défaut si aucun discount
        }
        return product;
    }

    public ProductCategoryEntity productCategoryModelToProductCategoryEntity(ProductCategory productCategory) {
        ProductCategoryEntity productCategoryEntity = mapper.map(productCategory, ProductCategoryEntity.class);
        productCategoryEntity.setId(productCategory.getId());
        productCategoryEntity.setDescription(productCategory.getDescription());
        return productCategoryEntity;
    }

    public ProductCategory productCategoryEntityToProductCategoryModel(ProductCategoryEntity productCategoryEntity) {
        ProductCategory productCategory = mapper.map(productCategoryEntity, ProductCategory.class);
        productCategory.setId(productCategoryEntity.getId());
        productCategory.setDescription(productCategoryEntity.getDescription());
        return productCategory;
    }

    public DiscountEntity discountModelToDiscountEntity(Discount discount) {
        DiscountEntity discountEntity = mapper.map(discount, DiscountEntity.class);
        return discountEntity;
    }

    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity) {
        if (discountEntity == null) {
            return null;
        }
        Discount discount = mapper.map(discountEntity, Discount.class);

        return discount;
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        Translation translation = mapper.map(translationEntity, Translation.class);
        translation.setLanguage(translationEntity.getLanguage().getName());
        return translation;
    }

}
