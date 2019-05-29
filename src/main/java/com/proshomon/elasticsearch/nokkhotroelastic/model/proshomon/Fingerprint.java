package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.enums.FingerprintType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Fingerprint {
	@NotNull
	private String key;
	private FingerprintType type;
}
