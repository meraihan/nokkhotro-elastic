package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Consultation extends MedicalService {

	private ServicePackage servicePackage;
	private String advice;
	private String symptoms;
	private String comments;
}
