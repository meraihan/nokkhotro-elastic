package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;

import java.util.Date;

@Data
public class Pharmacy {
    private Integer id;
    private String pharmacyName;
    private String phone;
    private String divisionId;
    private String districtId;
    private String upazillaId;
    private String municipalityId;
    private String ownerName;
    private String mouFile;
    private Boolean haveHospitalId;
    private String hospitalId;
    private String licenceNo;
    private String registrationId;
    private String bankAccountNo;
    private String bankAccountName;
    private String bankName;
    private String bankAccountBranch;
    private String bankRoutingNo;
    private Boolean status;
    private Date createdAt;
    private Date updatedAt;
}
