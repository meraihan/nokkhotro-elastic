package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.enums.ServiceCategory;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.generic.services.DiagnosticTestService;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.generic.services.PrescribedMedicines;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.generic.services.SurgicalProceduresService;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(type = "prescription", indexName = "prescription")
public class Prescription {
	@Id
	private String id;
	private String beneficiaryId;
    private BigDecimal cumulativeCost;
	private String uniqueIdentifier;
	private String comments;
	private ServiceCategory category;
	private Consultation consultationService;
	private Set<SurgicalProceduresService> surgicalProceduresServices = new HashSet<>();
	private Set<DiagnosticTestService> diagnosticTestServices = new HashSet<>();
	private Set<PrescribedMedicines> prescribedMedicines = new HashSet<>();
	@Field(type = FieldType.Boolean)
	private Boolean isComplete = false;
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date createdAt = new Date();
	
	public boolean sameAs(Prescription b) {
		Prescription a = this;
		return a.getBeneficiaryId().equals(b.getBeneficiaryId()) && a.getUniqueIdentifier().equals(b.getUniqueIdentifier());
	}
}
