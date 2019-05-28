package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.*;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.DiagnosticCenterRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.HospitalRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.ServiceProviderRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.SurgeriesProcedureRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceProviderTest {
    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    ServiceProviderRepository serviceProviderRepository;
    @Autowired
    HospitalRepository hospitalInfoRepository;
    @Autowired
    SurgeriesProcedureRepository surgeriesProcedureRepository;
    @Autowired
    DiagnosticCenterRepository diagnosticCenterRepository;

    @Test
//    @Ignore
    public void saveServiceProvider(){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceProvider> serviceProviderList = serviceProviderRepository.findAll();

        for (ServiceProvider provider: serviceProviderList){
            ServiceProvider serviceProvider = new ServiceProvider();
            serviceProvider.setId(provider.getId());
            serviceProvider.setName(provider.getName());
            serviceProvider.setPhone(provider.getPhone());
            serviceProvider.setContactPerson(provider.getContactPerson());
            serviceProvider.setEmail(provider.getEmail());
            serviceProvider.setDivisionId(provider.getDivisionId());
            serviceProvider.setDistrictId(provider.getDistrictId());
            serviceProvider.setUpazillaId(provider.getUpazillaId());
            serviceProvider.setMunicipalityId(provider.getMunicipalityId());
            serviceProvider.setAddress(provider.getAddress());
            serviceProvider.setOwnerName(provider.getOwnerName());
            serviceProvider.setMouFileLocation(provider.getMouFileLocation());
            serviceProvider.setRegistrationNo(provider.getRegistrationNo());
            serviceProvider.setLicenseNumber(provider.getLicenseNumber());
            serviceProvider.setBankAccountNumber(provider.getBankAccountNumber());
            serviceProvider.setBankAccountName(provider.getBankAccountName());
            serviceProvider.setBankName(provider.getBankName());
            serviceProvider.setBankAccountBranch(provider.getBankAccountBranch());
            serviceProvider.setBankRoutingNumber(provider.getBankRoutingNumber());
            serviceProvider.setIsActive(provider.getIsActive());
            serviceProvider.setCategories(provider.getCategories());
            Hospital hospital = new Hospital();
            List<ConsultationsService> consultationsServiceList =
                    hospitalInfoRepository.findAllConsultationServiceBySPId(provider.getId());
            hospital.setConsultations(consultationsServiceList);
            List<SurgeriesService>  surgeriesServiceList =
                    hospitalInfoRepository.findAllSurgeriesBySPId(provider.getId());
            hospital.setSurgeries(surgeriesServiceList);
            serviceProvider.setHospital(hospital);

            DiagnosticCenter diagnosticCenter = new DiagnosticCenter();
            List<DiagnosticTests> diagnosticTests =
                    diagnosticCenterRepository.findAllDiagnosticTestsServiceBySPId(provider.getId());
            diagnosticCenter.setDiagnosticTests(diagnosticTests);
            serviceProvider.setDiagnosticCenter(diagnosticCenter);
            serviceProvider.setCategories(provider.getCategories());
            serviceProvider.setCreatedAt(provider.getCreatedAt());

            String url = this.url + "service_provider/service_provider/";
            ResponseEntity<ServiceProvider> responseEntity =
                    restTemplate.postForEntity(url, serviceProvider, ServiceProvider.class);
            log.info("Status: {}", responseEntity.getStatusCode());

        }

    }
}
