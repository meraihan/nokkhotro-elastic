package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.records;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.GenericRecords;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "surgery", type = "surgery")
@Data
@NoArgsConstructor
public class SurgicalProceduresRecord extends GenericRecords {
	
	public SurgicalProceduresRecord(String id, String name) {
		super(id, name);
	}
}
