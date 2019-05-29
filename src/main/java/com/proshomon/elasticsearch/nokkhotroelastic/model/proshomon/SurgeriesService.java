package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Data
@Document(indexName = "surgeries_service", type = "surgeries_service")
public class SurgeriesService extends GenericRecords{
    private BigDecimal price;
}
