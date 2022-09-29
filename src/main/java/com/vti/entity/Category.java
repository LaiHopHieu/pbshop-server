package com.vti.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false,length = 50,unique = true)
    private String name;

    @Column(name = "created_date",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "updated_date",nullable = false,updatable = false)
    @UpdateTimestamp
    private LocalDate updatedDate;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<Product> products;

}
