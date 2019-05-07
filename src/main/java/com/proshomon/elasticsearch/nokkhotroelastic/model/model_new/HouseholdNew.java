package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import lombok.Data;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "household", type = "household")
public class HouseholdNew {
	@Id
	private String id;
	private String headBeneficiaryId;
	private String householdName;
	private Integer size;
	private String smartCardId;
	private String divisionId;
	private String districtId;
	private String upazillaId;
	private String wardNo;
	private String occupation;
	private String municipalityId;
	private String addedByUserId;
	private String phone;
	private GeoPoint geoPoint;
	private UserNew addedBy;
	private Boolean isActive;
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;
	
	
}
