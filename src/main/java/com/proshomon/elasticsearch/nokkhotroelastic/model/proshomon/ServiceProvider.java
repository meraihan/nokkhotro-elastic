package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.enums.ServiceProviderType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Data
@Document(indexName = "service_provider", type = "service_provider")
public class ServiceProvider {
	@Id
	private String id;
	private String name;
	private String phone;
	private String contactPerson;
	private String email;
	private String divisionId;
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
    //	return both hospital and diagonstic center based on services provider id
    private Hospital hospital;
	private DiagnosticCenter diagnosticCenter;
	private Pharmacy pharmacy;
	private Set<ServiceProviderType> categories;
	
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date createdAt;
}
