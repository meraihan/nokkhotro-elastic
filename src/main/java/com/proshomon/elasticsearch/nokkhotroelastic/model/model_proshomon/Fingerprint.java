package com.datasoft.proshomon.backend.model;

import com.datasoft.proshomon.backend.model.enums.FingerprintType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Fingerprint {
	@NotNull
	private String key;
	private FingerprintType type;
}
