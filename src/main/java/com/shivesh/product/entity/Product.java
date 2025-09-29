package com.shivesh.product.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    private Category  category;
}
