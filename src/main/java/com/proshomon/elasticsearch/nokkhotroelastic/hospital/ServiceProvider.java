package com.proshomon.elasticsearch.nokkhotroelastic.hospital;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.enums.ServiceProviderType;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@Document(indexName = "service_provider", type = "service_provider")
public class ServiceProvider extends GenericRecords{
    private HospitalInfo hospitalInfo;
    private List<DiagnosticTestsService> diagnosticTestsServiceList;
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
    private String registrationNo;
    private String licenceNo;
    private String bankAccountNo;
    private String bankAccountName;
    private String bankName;
    private String bankAccountBranch;
    private String bankRoutingNo;
    private Boolean isActive;
    private ServiceProviderType serviceProviderType;
    private Boolean isConsultationServiceApplicable;
    private Boolean isSurgeriesServiceApplicable;
    private Boolean isDiagnosticTestServiceApplicable;
    private Boolean isMedicineServiceApplicable;
    private String serviceCategory;
}
