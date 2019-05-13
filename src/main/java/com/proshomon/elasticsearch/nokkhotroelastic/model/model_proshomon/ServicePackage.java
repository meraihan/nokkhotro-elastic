package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicePackage {
	@Id
	private String id;
	private String name;
	private BigDecimal price = BigDecimal.ZERO;
	
	public ServicePackage(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
}
