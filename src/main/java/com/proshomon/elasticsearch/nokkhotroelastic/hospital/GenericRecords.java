package com.proshomon.elasticsearch.nokkhotroelastic.hospital;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class GenericRecords {
	@Id
	private String id;
	private String name;
}
