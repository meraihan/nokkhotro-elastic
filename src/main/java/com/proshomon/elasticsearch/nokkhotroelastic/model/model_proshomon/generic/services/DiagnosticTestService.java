package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.services;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.MedicalService;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class DiagnosticTestService extends MedicalService {
	private String name;
	private String diagnosticTestRecordId;
	private BigDecimal price = BigDecimal.ZERO;
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		DiagnosticTestService that = (DiagnosticTestService) o;
		return diagnosticTestRecordId.equals(that.diagnosticTestRecordId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), diagnosticTestRecordId);
	}
}
