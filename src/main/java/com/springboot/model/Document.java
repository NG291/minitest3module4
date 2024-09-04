package com.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "document")
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private int year;
    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
