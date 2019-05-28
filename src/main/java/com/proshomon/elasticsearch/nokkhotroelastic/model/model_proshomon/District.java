package com.datasoft.proshomon.backend.model;

import com.datasoft.proshomon.backend.model.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "district", indexName = "district")
@Getter
public class District extends Area {
	private AreaType type = AreaType.DISTRICT;
	
	
}
