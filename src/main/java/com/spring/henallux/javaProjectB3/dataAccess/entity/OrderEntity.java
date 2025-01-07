package com.spring.henallux.javaProjectB3.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @JoinColumn(name="user_id", referencedColumnName = "id")
    @ManyToOne
    private UserEntity user;

    @Column(name="is_paid")
    private Boolean isPaid;

    @OneToMany(mappedBy="order")
    private Collection<OrderLineEntity> orderLines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Collection<OrderLineEntity> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Collection<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }
}
