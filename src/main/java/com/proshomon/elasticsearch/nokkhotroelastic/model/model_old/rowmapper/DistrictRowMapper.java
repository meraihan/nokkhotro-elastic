package com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper;


import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.District;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictRowMapper implements RowMapper<District> {
    @Override
    public District mapRow(ResultSet rs, int i) throws SQLException {
        District district = new District();
        district.setId(rs.getInt("id"));
        district.setCode(rs.getInt("Code"));
        district.setName(rs.getString("Name"));
        district.setDivisionId(rs.getInt("DivisionId"));
        return district;
    }
}
