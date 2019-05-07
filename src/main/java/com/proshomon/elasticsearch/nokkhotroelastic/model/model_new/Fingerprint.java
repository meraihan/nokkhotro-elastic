package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.FingerprintType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Fingerprint {
	@NotNull
	private String key;
	private FingerprintType type;
}
