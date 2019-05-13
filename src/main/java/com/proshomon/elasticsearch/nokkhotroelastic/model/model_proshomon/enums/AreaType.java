package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums;

import lombok.Getter;

@Getter
public enum AreaType {
	DIVISION(1), DISTRICT(2), UPAZILLA(3), MUNICIPALITY(4), WARD(5);
	
	private Integer id;
	
	AreaType(Integer id) {
		this.id = id;
	}
}
