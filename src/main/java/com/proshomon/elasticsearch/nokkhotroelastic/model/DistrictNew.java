package com.proshomon.elasticsearch.nokkhotroelastic.model;

import com.proshomon.elasticsearch.nokkhotroelastic.model.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "district", indexName = "district")
@Getter
public class DistrictNew extends Area {
	private AreaType type = AreaType.DISTRICT;
	
	
}
