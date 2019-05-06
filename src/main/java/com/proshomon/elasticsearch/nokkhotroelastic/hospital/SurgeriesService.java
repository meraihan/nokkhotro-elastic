package com.proshomon.elasticsearch.nokkhotroelastic.hospital;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "surgeries_service", type = "surgeries_service")
public class SurgeriesService extends GenericRecords{
    private double fee;
}
