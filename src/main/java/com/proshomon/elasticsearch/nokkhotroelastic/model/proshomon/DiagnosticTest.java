package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import lombok.Data;

@Data
public class DiagnosticTest {
	private ServicePackage test;
	private Boolean isComplete;
}
