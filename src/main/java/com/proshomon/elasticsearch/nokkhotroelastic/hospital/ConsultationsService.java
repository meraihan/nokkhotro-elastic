package com.proshomon.elasticsearch.nokkhotroelastic.hospital;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "consultation_service", type = "consultation_service")
public class ConsultationsService extends GenericRecords{
    private double fee;
}
