package com.datasoft.proshomon.backend.model;

import com.datasoft.proshomon.backend.model.enums.ServiceCategory;
import com.datasoft.proshomon.backend.model.exception.ErrorCodes;
import com.datasoft.proshomon.backend.model.exception.InvalidServiceCategoryException;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Balance {
    private BigDecimal phc;
    private BigDecimal maternity;
    private BigDecimal accident;
	
	public BigDecimal getBalanceByServiceCategory(ServiceCategory serviceCategory) {
		if (serviceCategory == ServiceCategory.PHC) {
			return phc;
		} else if (serviceCategory == ServiceCategory.MATERNITY) {
			return maternity;
		} else if (serviceCategory == ServiceCategory.ACCIDENT) {
			return accident;
		}
		throw new InvalidServiceCategoryException(serviceCategory, ErrorCodes.SC_0000);
	}
}
