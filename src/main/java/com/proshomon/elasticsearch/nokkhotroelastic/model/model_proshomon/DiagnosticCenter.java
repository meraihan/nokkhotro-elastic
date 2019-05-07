package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;

import java.util.List;

@Data
public class DiagnosticCenter {
    private List<DiagnosticTests> diagnosticTests;
}

