package com.datasoft.proshomon.backend.model;

import lombok.Data;

@Data
public class DiagnosticTest {
	private ServicePackage test;
	private Boolean isComplete;
}
