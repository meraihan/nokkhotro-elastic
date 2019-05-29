package com.proshomon.elasticsearch.nokkhotroelastic.model.elasticsearch;

import lombok.Data;

@Data
public class Hit {
    private String _index;
    private String _type;
    private String _id;
    private String _score;
    private Source _source;
}
