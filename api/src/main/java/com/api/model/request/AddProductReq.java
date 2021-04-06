package com.api.model.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AddProductReq {
    @NotNull(message = "Ürün adı boş olamaz!")
    private String name;
    @NotNull(message = "Ürün adeti boş olamaz!")
    @Min(value = 1, message = "Ürün adeti en az 1 girilmelidir!")
    private Integer piece;
    @NotNull(message = "Ürün tutarı boş olamaz!")
    private BigDecimal price;
}
