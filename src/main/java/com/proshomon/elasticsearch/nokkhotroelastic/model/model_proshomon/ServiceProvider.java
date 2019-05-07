package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "service_provider", type = "service_provider")
public class ServiceProvider extends GenericRecords{
    private String phone;
    private String contactPerson;
    private String email;
    private String  divisionId;
    private String districtId;
    private String upazillaId;
    private String municipalityId;
    private String address;
    private String ownerName;
    private String mouFileLocation;
    private String bankName;
    private String bankAccountName;
    private String bankAccountNumber;
    private String bankAccountBranch;
    private String bankRoutingNumber;
    private String registrationNo;
    private String licenseNumber;
    private Boolean isActive;
    private Hospital hospital;
    private DiagnosticCenter diagnosticCenter;
    private Pharmacy pharmacy;
    private String categories;
}
