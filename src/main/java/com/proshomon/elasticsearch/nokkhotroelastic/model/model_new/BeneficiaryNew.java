package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.DisabilityType;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.Relationship;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
	private String gender;
	private String maritalStatus;
	private Relationship relationshipWithHead;
	private Date dateOfBirth;
	private DisabilityType disabilityType;
	@Field(type = FieldType.Nested, includeInParent = true)
	private Set<Fingerprint> fingerprints = new HashSet<>();
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;

	public boolean addFingerprint(Fingerprint fingerprint) {
		return this.fingerprints.add(fingerprint);
	}
}

