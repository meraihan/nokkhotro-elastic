package com.proshomon.elasticsearch.nokkhotroelastic.model;

import com.proshomon.elasticsearch.nokkhotroelastic.model.enums.FingerprintType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Fingerprint {
	@NotNull
	private String key;
	private FingerprintType type;
}
