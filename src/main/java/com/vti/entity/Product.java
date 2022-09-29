package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "sale_price",nullable = false)
    private double salePrice;

    @Column(name = "thumbnail_url",nullable = false)
    private String thumbnailUrl;

    @Column(name = "description",length = 1023,nullable = false)
    private String description;

    @Column(name = "ram",nullable = false,length = 50)
    @Enumerated(value = EnumType.STRING)
    private Ram ram;

    @Column(name = "created_date",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "updated_date",nullable = false,updatable = false)
    @UpdateTimestamp
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id",nullable = false)
    private Category category;

}
