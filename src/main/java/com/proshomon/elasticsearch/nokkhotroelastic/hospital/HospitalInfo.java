package com.proshomon.elasticsearch.nokkhotroelastic.hospital;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HospitalInfo extends GenericRecords{

    private List<ConsultationsService> consultationsServiceList;
    private List<SurgeriesService> surgeriesServiceList;
    private String phone;
    private String districtId;
    private String upazillaId;
    private String municipalityId;
    private String address;
    private String ownerName;
    private String registrationNo;
    private String licenceNo;
    private Boolean moApplicable;
    private int moCharge;
    private Boolean consultantApplicable;
    private int consultantCharge;
    private Boolean specialistApplicable;
    private int specialistCharge;
    private Boolean maternityFacilities;
    private int normalCharge;
    private int caesarianCharge;
    private Date createdAt;
    private Date updatedAt;
}
