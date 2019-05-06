package com.proshomon.elasticsearch.nokkhotroelastic.model_old;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Household {

    private Integer id;
    private int slNo;
    private List<Beneficiary> beneficiaryList;
    private String smartCardId;
    private String householdHeadName;
    private String contactNumber;
    private Status status;
    private String occupation;
    private int numOfMembers;
    private int divisionId;
    private String divisionIds;
    private int districtId;
    private String districtIds;
    private int upazillaId;
    private String upazillaIds;
    private int municipalityId;
    private String municipalityIds;
    private String wordNo;
    private String address;
    private double latitude;
    private double longitude;
    private Long createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
