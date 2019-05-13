package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.records;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.GenericRecords;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "diagnostic_test", type = "diagnostic_test")
@Data
@NoArgsConstructor
public class DiagnosticTestRecord extends GenericRecords {
	
	public DiagnosticTestRecord(String id, String name) {
		super(id, name);
	}
}
