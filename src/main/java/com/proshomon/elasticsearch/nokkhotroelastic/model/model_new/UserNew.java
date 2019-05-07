package com.proshomon.elasticsearch.nokkhotroelastic.model.model_new;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "user", type = "user")
@Data
public class UserNew {

	
	@Id
	private String id;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	@Field(type = FieldType.Date)
	private Date dateOfBirth;
	
	@Field(type = FieldType.Date)
	private Date createdAt = new Date();
	
}
