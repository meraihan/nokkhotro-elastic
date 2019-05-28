package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.AreaType;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "municipality", indexName = "municipality")
//@Getter
public class Municipalities extends Area {
	private AreaType type = AreaType.MUNICIPALITY;
}

