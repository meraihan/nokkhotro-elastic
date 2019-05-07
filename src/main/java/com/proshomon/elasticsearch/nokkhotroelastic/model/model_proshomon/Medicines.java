package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;

@Data
public class Medicines {
    private String id;
    private String manufacturer;
    private String brand;
    private String genericName;
    private String strength;
    private String medicineType;
    private String mrp;
}
