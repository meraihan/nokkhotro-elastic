package com.datasoft.proshomon.backend.model.assemblers;

import com.datasoft.proshomon.backend.controller.BeneficiaryController;
import com.datasoft.proshomon.backend.controller.HomeController;
import com.datasoft.proshomon.backend.controller.HouseholdController;
import com.datasoft.proshomon.backend.model.Beneficiary;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class BeneficiaryResourceAssembler implements ResourceAssembler<Beneficiary, Resource<Beneficiary>> {
    /**
     * Converts the given entity into an {@link ResourceSupport}.
     *
     * @param entity
     * @return
     */
    @Override
    public Resource<Beneficiary> toResource(Beneficiary entity) {
        Boolean doesProfilePhotoExist = !StringUtils.isEmpty(entity.getProfilePhoto());
        ArrayList<Link> links = new ArrayList<>();
        links.add(linkTo(methodOn(HouseholdController.class).info(entity.getHouseholdId())).withRel("household"));
        links.add(linkTo(methodOn(BeneficiaryController.class).info(entity.getId())).withSelfRel());
        if (doesProfilePhotoExist && !StringUtils.isEmpty(entity.getProfilePhoto().getLocation())) {
            links.add(linkTo(HomeController.class).slash(entity.getProfilePhoto().getLocation()).withRel("profilePhoto"));
        }
        return new Resource<>(entity, links);
    }
}
