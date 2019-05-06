package com.proshomon.elasticsearch.nokkhotroelastic.hospital;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "diagnostic_service", type = "diagnostic_service")
public class DiagnosticTestsService extends GenericRecords{
    private double fee;
}
