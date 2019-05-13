package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.services;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.MedicalService;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class SurgicalProceduresService extends MedicalService {
	private String name;
	private String surgicalProcedureRecordId;
	private BigDecimal price = BigDecimal.ZERO;
	@NotNull
	@Min(value = 1, message = "Invalid quantity")
	private Integer quantity;
	
}
