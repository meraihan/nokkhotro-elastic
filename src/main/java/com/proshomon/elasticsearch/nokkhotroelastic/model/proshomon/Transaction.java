package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.enums.ServiceCategory;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.enums.TransactionStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Document(indexName = "transaction", type = "transaction")
public class Transaction {
    @Id
    private String id;
    private String uniqueIdentifier;
    private String prescriptionId;
    private String prescriptionUniqueIdentifier;
    private String householdId;
    private String beneficiaryId;
    private ServiceCategory serviceCategory;
    private String serviceProviderId;
    private String serviceProviderName;
    private Set<ServiceSummary> services;

    private Boolean status;
    private TransactionStatus transactionStatus;
    private BigDecimal amount;
    @DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
    @Field(type = FieldType.Date)
    private Date createdAt = new Date();
}
