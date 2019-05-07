package com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Upazilla;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpazillaRowMapper implements RowMapper<Upazilla> {
    @Override
    public Upazilla mapRow(ResultSet rs, int i) throws SQLException {
        Upazilla upazilla = new Upazilla();
        upazilla.setId(rs.getInt("id"));
        upazilla.setCode(rs.getInt("Code"));
        upazilla.setDistrictId(rs.getInt("DistrictId"));
        upazilla.setName(rs.getString("Name"));
        return upazilla;
    }
}
