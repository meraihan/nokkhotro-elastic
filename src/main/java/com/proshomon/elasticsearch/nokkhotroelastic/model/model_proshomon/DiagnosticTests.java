package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "diagnostic_service", type = "diagnostic_service")
public class DiagnosticTests extends GenericRecords{
    private double charge;
}
