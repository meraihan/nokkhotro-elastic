package com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper;


import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Household;
import com.proshomon.elasticsearch.nokkhotroelastic.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseholdRowMapper  implements RowMapper<Household> {

    @Override
    public Household mapRow(ResultSet rs, int i) throws SQLException {
        Household household = new Household();
        household.setId(rs.getInt("id"));
        household.setSmartCardId(rs.getString("smart_card_id"));
        household.setHouseholdHeadName(rs.getString("household_head_name"));
        household.setContactNumber(rs.getString("contact_number"));
        household.setCardNo(rs.getString("card_no"));
        household.setStatus(Household.Status.valueOf(rs.getString("status")));
        household.setOccupation(rs.getString("occupation"));
        household.setNumOfMembers(rs.getInt("number_of_members"));
        household.setDistrictId(rs.getInt("division_id"));
        household.setDivisionIds(rs.getString("division_ids"));
        household.setDistrictId(rs.getInt("district_id"));
        household.setDistrictIds(rs.getString("district_ids"));
        household.setUpazillaId(rs.getInt("upazilla_id"));
        household.setUpazillaIds(rs.getString("upazilla_ids"));
        household.setMunicipalityId(rs.getInt("municipality_id"));
        household.setMunicipalityIds(rs.getString("municipality_ids"));
        household.setWordNo(rs.getString("word_no"));
        household.setAddress(rs.getString("address"));
        household.setLatitude(rs.getDouble("latitude"));
        household.setLongitude(rs.getDouble("longitude"));
        household.setCreatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("created_at")));
        household.setUpdatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("updated_at")));
        household.setDeletedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("deleted_at")));
        return household;
    }
}
