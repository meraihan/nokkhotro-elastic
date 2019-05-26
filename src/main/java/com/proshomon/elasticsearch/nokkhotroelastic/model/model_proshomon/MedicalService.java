package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.ServiceStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode
public class MedicalService {
	private String id;
	private String serviceProviderId;
//	/**
//	 * Any of PHC, MATERNITY, ACCIDENT;
//	 */
//	private ServiceCategory category;
//	/**
//	 * Any of CONSULTATION, DIAGNOSIS, PHARMACEUTICAL_SERVICE, SURGERY;
//	 */
//	private ServiceType type;
	private boolean isCompleted;
	private BigDecimal totalCost = BigDecimal.ZERO;
	private ServiceStatus status;

	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date createdAt = new Date();
}
