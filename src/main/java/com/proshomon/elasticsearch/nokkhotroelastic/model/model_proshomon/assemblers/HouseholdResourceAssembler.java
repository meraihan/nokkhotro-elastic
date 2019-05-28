package com.datasoft.proshomon.backend.model.assemblers;

import com.datasoft.proshomon.backend.controller.BeneficiaryController;
import com.datasoft.proshomon.backend.controller.HouseholdController;
import com.datasoft.proshomon.backend.model.Household;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class HouseholdResourceAssembler implements ResourceAssembler<Household, Resource<Household>> {
    /**
     * Converts the given household into an {@link ResourceSupport}.
     *
     * @param household
     * @return
     */
    @Override
    public Resource<Household> toResource(Household household) {
        return new Resource<>(
                household,
                linkTo(methodOn(BeneficiaryController.class).list(household.getId())).withRel("members"),
                linkTo(methodOn(HouseholdController.class).info(household.getId())).withSelfRel()
//				linkTo(methodOn(BeneficiaryController.class).fingerprints(household.getId())).withRel("fingerprints"),
//				linkTo(methodOn(BeneficiaryController.class).treatment(household.getId())).withRel("treatmentHistory")
        );
    }


}
