package com.datasoft.proshomon.backend.model.assemblers;

import com.datasoft.proshomon.backend.model.ServiceProvider;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class ServiceProviderResourceAssembler implements ResourceAssembler<ServiceProvider, Resource<ServiceProvider>> {
    /**
     * Converts the given serviceProviderId into an {@link ResourceSupport}.
     *
     * @param serviceProvider
     * @return
     */
    @Override
    public Resource<ServiceProvider> toResource(ServiceProvider serviceProvider) {
        return new Resource<>(
                serviceProvider
//                linkTo(methodOn(ServiceProviderController.class).list(serviceProvider.getId())).withRel("serviceProviders")
//                linkTo(methodOn(ServiceProviderController.class).info(serviceProvider.getId())).withSelfRel()
//				linkTo(methodOn(ServiceProviderController.class).fingerprints(serviceProvider.getId())).withRel("fingerprints"),
//				linkTo(methodOn(ServiceProviderController.class).treatment(serviceProvider.getId())).withRel("treatmentHistory")
        );
    }
}