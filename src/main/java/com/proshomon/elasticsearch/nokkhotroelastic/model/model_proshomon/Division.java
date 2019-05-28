package com.datasoft.proshomon.backend.model;

import com.datasoft.proshomon.backend.model.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "division", indexName = "division")
@Getter
public class Division extends Area {
	private AreaType type = AreaType.DIVISION;
}
