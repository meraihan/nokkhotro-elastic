package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.DisabilityType;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.Gender;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.MaritalStatus;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.Relationship;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(indexName = "beneficiary", type = "beneficiary")
public class BeneficiaryNew {
	@Id
	private String id;
	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	@NotNull
	@Size(min = 11, max = 13, message = "Please check your mobile number")
	private String phone;
	@NotNull(message = "Household ID is required")
	private String householdId;
	@Field(type = FieldType.Nested, includeInParent = true)
	private Image profilePhoto;
	private Boolean isActive;
	private String addedByUserId;
	private Gender gender;
	private MaritalStatus maritalStatus;
	private Relationship relationshipWithHead;
	@DateTimeFormat(pattern = Strings.DATE_FORMAT)
	@Field(type = FieldType.Date)
	private Date dateOfBirth;
	private DisabilityType disabilityType;
	@Field(type = FieldType.Nested, includeInParent = true)
	private Set<Fingerprint> fingerprints = new HashSet<>();
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date createdAt = new Date();
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date updatedAt;
	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date deletedAt;

	public boolean addFingerprint(Fingerprint fingerprint) {
		return this.fingerprints.add(fingerprint);
	}
}

