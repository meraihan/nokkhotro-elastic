package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import lombok.Data;

import java.util.List;

@Data
public class Hospital {
    private Integer id;
    private List<ConsultationsService> consultations;
    private List<SurgeriesService> surgeries;
}
