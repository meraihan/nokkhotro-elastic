package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Balance {
    private BigDecimal phc;
    private BigDecimal maternity;
    private BigDecimal accident;
}
