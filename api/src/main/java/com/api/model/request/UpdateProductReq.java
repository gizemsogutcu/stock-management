package com.api.model.request;

import lombok.Data;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class UpdateProductReq {
    @NotNull(message = "Ürün id boş olamaz!")
    private Integer id;
    @NotNull(message = "Ürün adeti boş olamaz!")
    @Min(value = 1, message = "Ürün adeti en az 1 girilmelidir!")
    private Integer piece;
    @NotNull(message = "Ürün tutarı boş olamaz!")
    private BigDecimal price;
}
