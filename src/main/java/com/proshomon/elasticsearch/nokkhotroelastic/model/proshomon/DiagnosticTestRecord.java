package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "diagnostic_test_records", type = "diagnostic_test_records")
@Data
public class DiagnosticTestRecord extends GenericRecords {



}
