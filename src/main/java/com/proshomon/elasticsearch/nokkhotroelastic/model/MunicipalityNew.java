package com.proshomon.elasticsearch.nokkhotroelastic.model;

import com.proshomon.elasticsearch.nokkhotroelastic.model.enums.AreaType;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "municipality", indexName = "municipality")
//@Getter
public class MunicipalityNew extends Area {
	private AreaType type = AreaType.MUNICIPALITY;
}

