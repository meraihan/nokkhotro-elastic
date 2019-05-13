package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.ServiceCategory;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.ServiceType;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.TransactionStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Document(indexName = "transactions", type = "transactions")
public class Transaction {
    @Id
    private String id;
    private String prescriptionId;
    private String householdId;
    private String beneficiaryId;
    private ServiceType serviceType;
    private ServiceCategory serviceCategory;
    private String serviceProviderId;
    private Set<String> services;
    private Boolean status;
    private TransactionStatus transactionStatus;
    @Min(value = 0, message = "The value must be positive")
    private BigDecimal amount;
}
