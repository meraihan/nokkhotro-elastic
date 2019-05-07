package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "upazilla", indexName = "upazilla")
@Getter
public class UpazillaNew extends Area {
	private AreaType type = AreaType.UPAZILLA;
}

