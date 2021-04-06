package com.api.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer piece;
    private BigDecimal price;
}
