package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "division", indexName = "division")
@Getter
public class Divisions extends Area {
	private AreaType type = AreaType.DIVISION;
}
