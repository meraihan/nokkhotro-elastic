package com.proshomon.elasticsearch.nokkhotroelastic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class Area {
	@Id
	private String id;
	private String name;
	private String code;
	private String parentId;
}
