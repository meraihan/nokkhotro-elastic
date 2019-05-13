package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.generic.services;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.MedicalService;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.ServiceStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
public class PrescribedMedicines extends MedicalService {
//	private String id;
	private String medicineId;
	private String brand;
	private String genericName;
	private String strength;
	@Min(value = 1, message = "Invalid number of medicines allocated")
	private Integer allocated;
	@Min(value = 0, message = "Invalid number of medicines allocated")
	private Integer provided;
//	private Boolean isCompleted;
	private BigDecimal price = BigDecimal.ZERO;
	private String parentId;
//	@Field(type = FieldType.Date)
//	@DateTimeFormat(pattern = Strings.DATETIME_FORMAT)
//	private Date createdAt = new Date();
	
	public PrescribedMedicines(PrescribedMedicines medicines) {
		super();
		if (!StringUtils.isEmpty(medicines.getId())) {
			this.setId(medicines.getId().concat("-1"));
		}
		this.medicineId = medicines.getMedicineId();
		this.brand = medicines.getBrand();
		this.strength = medicines.getStrength();
		this.allocated = medicines.getAllocated() - medicines.getProvided();
		this.provided = 0;
		this.parentId = medicines.getId();
		this.setStatus(ServiceStatus.NOT_DONE);
		this.setTotalCost(null);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		PrescribedMedicines that = (PrescribedMedicines) o;
		return (Objects.equals(this.getId(), that.getId()) &&
				Objects.equals(this.getMedicineId(), that.getMedicineId()) &&
				Objects.equals(this.getBrand(), that.getBrand()) &&
				Objects.equals(this.getAllocated(), that.getAllocated()))
				||
				(Objects.equals(this.getId(), that.getId()) &&
				Objects.equals(medicineId, that.medicineId) &&
				Objects.equals(brand, that.brand) &&
				Objects.equals(strength, that.strength) &&
				Objects.equals(allocated, that.allocated) &&
				Objects.equals(provided, that.provided) &&
				Objects.equals(price, that.price) &&
				Objects.equals(parentId, that.parentId));
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.getId(), medicineId, brand, strength, allocated);
	}
}
