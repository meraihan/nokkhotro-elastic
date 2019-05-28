package com.datasoft.proshomon.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class ServiceSummary {
    private String id;
    private String name;
    @NotNull
    @Min(value = 1, message = "Invalid quantity")
    private Integer quantity;
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal totalCost = BigDecimal.ZERO;
}
