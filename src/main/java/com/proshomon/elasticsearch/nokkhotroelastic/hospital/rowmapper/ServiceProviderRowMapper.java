package com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.ServiceProvider;
import com.proshomon.elasticsearch.nokkhotroelastic.hospital.enums.ServiceProviderType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceProviderRowMapper implements RowMapper<ServiceProvider> {

    @Override
    public ServiceProvider mapRow(ResultSet rs, int i) throws SQLException {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setId(rs.getString("id"));
        serviceProvider.setName(rs.getString("name"));
        serviceProvider.setPhone(rs.getString("phone"));
        serviceProvider.setContactPerson(rs.getString("contact_person"));
        serviceProvider.setEmail(rs.getString("email"));
        serviceProvider.setDistrictId(rs.getString("division_id"));
        serviceProvider.setUpazillaId(rs.getString("upazilla_id"));
        serviceProvider.setMunicipalityId(rs.getString("municipilities_id"));
        serviceProvider.setAddress(rs.getString("address"));
        serviceProvider.setOwnerName(rs.getString("owner_name"));
        serviceProvider.setMouFileLocation(rs.getString("mou_file_location"));
        serviceProvider.setRegistrationNo(rs.getString("registration_no"));
        serviceProvider.setLicenceNo(rs.getString("licence_no"));
        serviceProvider.setBankAccountNo(rs.getString("bank_account_no"));
        serviceProvider.setBankAccountName(rs.getString("bank_account_name"));
        serviceProvider.setBankName(rs.getString("bank_name"));
        serviceProvider.setBankAccountBranch(rs.getString("bank_account_branch"));
        serviceProvider.setBankRoutingNo(rs.getString("bank_routing_no"));
        serviceProvider.setIsActive(rs.getBoolean("is_active"));
        serviceProvider.setServiceProviderType(ServiceProviderType.valueOf(rs.getString("service_provider_type")));
        serviceProvider.setIsConsultationServiceApplicable(rs.getBoolean("is_consultations_service_applicable"));
        serviceProvider.setIsSurgeriesServiceApplicable(rs.getBoolean("is_surgeries_service_applicable"));
        serviceProvider.setIsDiagnosticTestServiceApplicable(rs.getBoolean("is_diagnostic_tests_service_applicable"));
        serviceProvider.setIsMedicineServiceApplicable(rs.getBoolean("is_madicine_service_applicable"));
        serviceProvider.setServiceCategory(rs.getString("service_catagory"));
        return serviceProvider;
    }
}
