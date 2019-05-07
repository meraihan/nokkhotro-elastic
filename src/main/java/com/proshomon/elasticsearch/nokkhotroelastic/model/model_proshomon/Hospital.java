package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;

import java.util.List;

@Data
public class Hospital {
    private List<ConsultationsService> consultations;
    private List<SurgeriesService> surgeries;
}
