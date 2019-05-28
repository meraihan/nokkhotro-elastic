package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "district", indexName = "district")
@Getter
public class Districts extends Area {
	private AreaType type = AreaType.DISTRICT;
	
	
}
