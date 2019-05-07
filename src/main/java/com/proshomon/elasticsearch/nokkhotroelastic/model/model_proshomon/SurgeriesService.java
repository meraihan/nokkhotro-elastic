package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "surgeries_service", type = "surgeries_service")
public class SurgeriesService extends GenericRecords{
    private double charge;
}
