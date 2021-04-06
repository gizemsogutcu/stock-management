package com.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
