package br.com.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "product", sequenceName = "SQ_PRODUCT", allocationSize = 1)
public class Product {
    @Id
    @GeneratedValue(generator = "product", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 15)
    private String name;
    @Column(length = 255)
    private String description;
    private double price;
    private int quantity;
}
