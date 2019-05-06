package com.proshomon.elasticsearch.nokkhotroelastic.ElasticModel;

import lombok.Data;

import java.util.List;

@Data
public class Hits {
    private int total;
    private int max_score;
    private List<Hit> hits;

}
