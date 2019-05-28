package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Document(indexName = "user", type = "user")
@Data
public class Users {

	
	@Id
	private String id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String serviceProviderId;
	private Boolean isServiceProvider;
	private Boolean isEnabled;
	private Boolean isActive;
	private Set<String> roles;
	
	@DateTimeFormat(pattern = Strings.DATE_FORMAT)
	@Field(type = FieldType.Date)
	private Date dateOfBirth;

	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
	@Field(type = FieldType.Date)
	private Date createdAt = new Date();
	
}
