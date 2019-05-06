package com.proshomon.elasticsearch.nokkhotroelastic.hospital;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "generic_surgical_procedures", type = "generic_surgical_procedures")
@Data
public class SurgicalProceduresRecord extends GenericRecords {
}
