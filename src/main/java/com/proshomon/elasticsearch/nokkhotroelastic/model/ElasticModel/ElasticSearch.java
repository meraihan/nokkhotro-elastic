package com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel;

import lombok.Data;

@Data
public class ElasticSearch {
    private int took;
    private boolean timed_out;
    private Shards _shards;
    private Hits hits;
}