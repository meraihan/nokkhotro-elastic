package com.datasoft.proshomon.backend.model;

import com.datasoft.proshomon.backend.model.enums.AreaType;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(type = "upazilla", indexName = "upazilla")
@Getter
public class Upazilla extends Area {
	private AreaType type = AreaType.UPAZILLA;
}

