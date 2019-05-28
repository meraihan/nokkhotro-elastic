package com.datasoft.proshomon.backend.model.assemblers;

import com.datasoft.proshomon.backend.controller.AreaController;
import com.datasoft.proshomon.backend.model.Area;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class AreaResourceAssembler implements ResourceAssembler<Area, Resource<Area>> {
	
	
	/**
	 * Converts the given entity into an {@link ResourceSupport}.
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public Resource<Area> toResource(Area entity) {
		return new Resource<>(entity,
				linkTo(methodOn(AreaController.class).list(null, null, null, null)).withRel("all"));
	}
}
