package com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.HospitalInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalInfoRowMapper implements RowMapper<HospitalInfo> {

    @Override
    public HospitalInfo mapRow(ResultSet rs, int i) throws SQLException {
        HospitalInfo hospitalInfo = new HospitalInfo();
        hospitalInfo.setId(rs.getString("id"));
        hospitalInfo.setName(rs.getString("hospital_name"));
        hospitalInfo.setPhone(rs.getString("contact_no"));
        hospitalInfo.setDistrictId(rs.getString("district_id"));
        hospitalInfo.setUpazillaId(rs.getString("upazilla_id"));
        hospitalInfo.setMunicipalityId(rs.getString("municipality_id"));
        hospitalInfo.setAddress(rs.getString("hospital_address"));
        hospitalInfo.setOwnerName(rs.getString("owner_name"));
        hospitalInfo.setRegistrationNo(rs.getString("registration_no"));
        hospitalInfo.setLicenceNo(rs.getString("licence_number"));
        hospitalInfo.setMoApplicable(rs.getBoolean("mo_applicale"));
        hospitalInfo.setMoCharge(rs.getInt("mo_charge"));
        hospitalInfo.setConsultantApplicable(rs.getBoolean("consultant_applicable"));
        hospitalInfo.setConsultantCharge(rs.getInt("consultant_charge"));
        hospitalInfo.setMaternityFacilities(rs.getBoolean("maternity_facilities"));
        hospitalInfo.setNormalCharge(rs.getInt("normal_charge"));
        hospitalInfo.setCaesarianCharge(rs.getInt("caesarian_charge"));
        hospitalInfo.setCreatedAt(rs.getDate("created_at"));
        hospitalInfo.setUpdatedAt(rs.getDate("updated_at"));
        return hospitalInfo;
    }
}
