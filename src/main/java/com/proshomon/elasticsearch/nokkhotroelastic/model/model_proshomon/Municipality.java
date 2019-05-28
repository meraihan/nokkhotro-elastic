package com.datasoft.proshomon.backend.model;

import com.datasoft.proshomon.backend.model.enums.AreaType;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "municipality", indexName = "municipality")
//@Getter
public class Municipality extends Area {
	private AreaType type = AreaType.MUNICIPALITY;
}

