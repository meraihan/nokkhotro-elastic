package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "generic_surgical_procedures", type = "generic_surgical_procedures")
public class SurgicalProceduresRecord extends GenericRecords {
}
