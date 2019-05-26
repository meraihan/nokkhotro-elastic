package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "surgery", type = "surgery")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SurgicalProceduresRecord extends GenericRecords {

    public SurgicalProceduresRecord(String id, String name) {
        super(id, name);
    }
}