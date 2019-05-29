package com.proshomon.elasticsearch.nokkhotroelastic.model.elasticsearch;

import lombok.Data;

@Data
public class Shards {
    private int total;
    private int successful;
    private int skipped;
    private int failed;
}
