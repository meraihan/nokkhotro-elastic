package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.ServiceCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class BeneficiaryTreatmentHistory {
    private String prescriptionUniqueIdentifier;
    private String serviceProviderName;
    private ServiceCategory serviceCategory;
    private Set<ServiceSummary> services;
    private Date date;
    private BigDecimal amount;
}
