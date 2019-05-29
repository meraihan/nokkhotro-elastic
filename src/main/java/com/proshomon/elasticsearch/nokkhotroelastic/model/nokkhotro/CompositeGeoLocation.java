package com.proshomon.elasticsearch.nokkhotroelastic.model.nokkhotro;

import lombok.Data;

import java.util.List;

@Data
public class CompositeGeoLocation {
    private List<Division> divisionList;
    private List<District> districtList;
    private List<Upazilla> upazillaList;
    private List<PostOffice> postOfficeList;
}
