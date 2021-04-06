package com.api.entity.custom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Data
public class ProductSupplier {

    @Id
    private Integer id;
    private String name;
    private Integer piece;
    private Double price;
    private Integer supplierId;
    private String supplierName;
}
