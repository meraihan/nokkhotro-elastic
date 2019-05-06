package com.proshomon.elasticsearch.nokkhotroelastic.hospitals;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.*;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.hospital.DiagnosticCenterRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.hospital.HospitalInfoRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.hospital.ServiceProviderRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.hospital.SurgeriesProcedureRepository;
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
    HospitalInfoRepository hospitalInfoRepository;
    @Autowired
    SurgeriesProcedureRepository surgeriesProcedureRepository;
    @Autowired
    DiagnosticCenterRepository diagnosticCenterRepository;

    @Test
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
            serviceProvider.setLicenceNo(provider.getLicenceNo());
            serviceProvider.setBankAccountNo(provider.getBankAccountNo());
            serviceProvider.setBankAccountName(provider.getBankAccountName());
            serviceProvider.setBankName(provider.getBankName());
            serviceProvider.setBankAccountBranch(provider.getBankAccountBranch());
            serviceProvider.setBankRoutingNo(provider.getBankRoutingNo());
            serviceProvider.setIsActive(provider.getIsActive());
            serviceProvider.setServiceProviderType(provider.getServiceProviderType());
            HospitalInfo hospitalInfo = new HospitalInfo();
            List<ConsultationsService> consultationsServiceList =
                    hospitalInfoRepository.findAllConsultationServiceBySPId(provider.getId());
            hospitalInfo.setConsultationsServiceList(consultationsServiceList);
            List<SurgeriesService>  surgeriesServiceList =
                    hospitalInfoRepository.findAllSurgeriesBySPId(provider.getId());
            hospitalInfo.setSurgeriesServiceList(surgeriesServiceList);
            serviceProvider.setHospitalInfo(hospitalInfo);
            List<DiagnosticTestsService> diagnosticTestsServiceList  =
                    diagnosticCenterRepository.findAllDiagnosticTestsServiceBySPId(provider.getId());
            serviceProvider.setDiagnosticTestsServiceList(diagnosticTestsServiceList);
            serviceProvider.setServiceCategory(provider.getServiceCategory());


            String url = this.url + "service_provider/service_provider/";
            ResponseEntity<ServiceProvider> responseEntity =
                    restTemplate.postForEntity(url, serviceProvider, ServiceProvider.class);
            log.info("Status: {}", responseEntity.getStatusCode());

        }

    }
}
