package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.enums.AreaType;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "municipality", indexName = "municipality")
//@Getter
public class Municipalities extends Area {
	private AreaType type = AreaType.MUNICIPALITY;
}

