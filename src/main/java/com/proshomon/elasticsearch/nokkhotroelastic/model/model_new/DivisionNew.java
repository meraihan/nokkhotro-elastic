package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "division", indexName = "division")
@Getter
public class DivisionNew extends Area {
	private AreaType type = AreaType.DIVISION;
}
