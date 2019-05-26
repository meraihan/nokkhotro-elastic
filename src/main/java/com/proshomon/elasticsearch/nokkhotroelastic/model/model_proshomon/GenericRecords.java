package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericRecords {
	@Id
	private String id;
	private String name;
}
