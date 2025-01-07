package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.dataAccess.entity.OrderEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.OrderRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDAO implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;
    private OrderLineDAO orderLineDAO;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, OrderLineDAO orderLineDAO, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.orderLineDAO = orderLineDAO;
        this.providerConverter = providerConverter;
    }

    public Order save(Order order) {
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderEntity = orderRepository.save(orderEntity);
        return providerConverter.orderEntityToOrderModel(orderEntity);
    }

    public ArrayList<Order> getOrdersByUsername_id(Integer userId) {
        List<OrderEntity> orderEntities = orderRepository.findAllByUser_Id(userId);

        ArrayList<Order> orders = new ArrayList<>();
        for (OrderEntity entity : orderEntities) {
            Order order = providerConverter.orderEntityToOrderModel(entity);

            // Charger les lignes de commande avec les produits
            order.setOrderLines(orderLineDAO.getOrderLinesByOrderId(entity.getId()));

            orders.add(order);

        }

        return orders;
    }

    public Order getOrderById(Integer orderId) {
        // Récupérer l'entité de la commande par son ID
        OrderEntity orderEntity = orderRepository.findById(orderId);

        if (orderEntity == null) {
            return null;
        }

        // Convertir l'entité en modèle
        Order order = providerConverter.orderEntityToOrderModel(orderEntity);

        // Charger les lignes de commande associées
        order.setOrderLines(orderLineDAO.getOrderLinesByOrderId(orderId));

        return order;
    }
}
