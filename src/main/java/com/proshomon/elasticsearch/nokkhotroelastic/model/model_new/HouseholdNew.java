package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import lombok.Data;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document(indexName = "household", type = "household")
public class HouseholdNew {
	@Id
	private String id;
	private String headBeneficiaryId;
	private String householdName;
	private String phone;
	private Integer size;
	private String smartCardId;
	private String divisionId;
	private String districtId;
	private String upazillaId;
	private String wardNo;
	private String occupation;
	private String municipalityId;
	private String addedByUserId;
	private GeoPoint location;
	@Field(type = FieldType.Nested, includeInParent = true)
	private HouseholdBalance householdBalance;
	private Boolean isActive;
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date createdAt = new Date();
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date updatedAt;
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date deletedAt;
	
	
}
