package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.records;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(indexName = "medicine", type = "medicine")
public class MedicineRecord {
    @Id
    private String id;
    @NotNull(message = "Manufacturer is required")
    private String manufacturer;
    @NotNull(message = "Brand is required")
    private String brand;
    @NotNull(message = "Generic Name is required")
    private String genericName;
    @NotNull(message = "Strength is required")
    private String strength;
    @NotNull(message = "MedicineRecord Type is required")
    private String medicineType;
    private String mrp;
}
