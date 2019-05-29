package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Data
@Document(indexName = "consultation_service", type = "consultation_service")
public class ConsultationsService extends GenericRecords{
    private BigDecimal price;
}
