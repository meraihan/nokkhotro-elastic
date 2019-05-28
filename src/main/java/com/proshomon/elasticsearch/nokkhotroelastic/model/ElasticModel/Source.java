package com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.HouseholdBalance;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Users;
import lombok.Data;
import org.elasticsearch.common.geo.GeoPoint;

import java.util.Date;

@Data
public class Source {
    private String id;
    private String name;
    private String code;
    private String parentId;
    private String type;

    private String headBeneficiaryId;
    private String householdName;
    private Integer size;
    private String smartCardId;
    private String cardNo;
    private String divisionId;
    private String districtId;
    private String upazillaId;
    private String wardNo;
    private String occupation;
    private String municipalityId;
    private String addedByUserId;
    private HouseholdBalance householdBalance;
    private String phone;
    private GeoPoint geoPoint;
    private Users addedBy;
    private Boolean isActive;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
