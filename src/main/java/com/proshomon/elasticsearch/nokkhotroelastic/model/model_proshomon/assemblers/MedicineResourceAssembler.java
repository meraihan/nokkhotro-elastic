package com.datasoft.proshomon.backend.model.assemblers;

import com.datasoft.proshomon.backend.controller.MedicineController;
import com.datasoft.proshomon.backend.model.generic.records.MedicineRecord;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class MedicineResourceAssembler implements ResourceAssembler<MedicineRecord, Resource<MedicineRecord>> {
    /**
     * Converts the given household into an {@link ResourceSupport}.
     *
     * @param medicineRecord
     * @return
     */
    @Override
    public Resource<MedicineRecord> toResource(MedicineRecord medicineRecord) {
        return new Resource<>(
		        medicineRecord,
                linkTo(methodOn(MedicineController.class).list(medicineRecord.getId())).withRel("medicines")
//                linkTo(methodOn(MedicineController.class).info(medicineRecord.getId())).withSelfRel()
//				linkTo(methodOn(BeneficiaryController.class).fingerprints(household.getId())).withRel("fingerprints"),
//				linkTo(methodOn(BeneficiaryController.class).treatment(household.getId())).withRel("treatmentHistory")
        );
    }
}
