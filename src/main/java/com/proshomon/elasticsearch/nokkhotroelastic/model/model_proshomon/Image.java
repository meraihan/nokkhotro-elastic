package com.datasoft.proshomon.backend.model;

import lombok.Data;

@Data
public class Image {
    private String location;
    private String hash;
    private Integer imageSize;
}
