package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "consultation_service", type = "consultation_service")
public class ConsultationsService extends GenericRecords{
    private double charge;
}
