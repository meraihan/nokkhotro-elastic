package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class GenericRecords {
	@Id
	private String id;
	private String name;
}
