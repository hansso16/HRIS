package com.soses.hris.common;

import java.time.LocalDateTime;

import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeAddressHistory;
import com.soses.hris.entity.EmployeeAddressHistoryPK;
import com.soses.hris.entity.EmployeeAddressPK;

public class EmployeeAddressHelper {

	public static boolean isChanged(EmployeeAddress dbObj, EmployeeAddress requestObj) {
		if (dbObj != null && requestObj != null) {
			if (!dbObj.getStreet().equals(requestObj.getStreet())
					|| !dbObj.getBarangay().getBarangayId().equals(requestObj.getBarangay().getBarangayId())
					|| !dbObj.getMunicipal().getMunicipalId().equals(requestObj.getMunicipal().getMunicipalId())
					|| !dbObj.getProvince().getProvinceId().equals(requestObj.getProvince().getProvinceId())
					|| !dbObj.getRegion().getRegionId().equals(requestObj.getRegion().getRegionId())) {
				return true;
			}
		}
		return false;
	}
	
	public static EmployeeAddressHistory convertToEmpAddressHistory(EmployeeAddress empAddress) {
		if (empAddress == null) {
			return null;
		}
		
		EmployeeAddressHistory empAddressHistory = new EmployeeAddressHistory();
		EmployeeAddressHistoryPK empAddressHistoryPK = new EmployeeAddressHistoryPK();
		EmployeeAddressPK empAddressPK = empAddress.getId();
		
		empAddressHistory.setStreet(empAddress.getStreet());
		empAddressHistory.setBarangay(empAddress.getBarangay());
		empAddressHistory.setMunicipal(empAddress.getMunicipal());
		empAddressHistory.setProvince(empAddress.getProvince());
		empAddressHistory.setRegion(empAddress.getRegion());
		empAddressHistory.setZipCode(empAddress.getZipCode());
		
		empAddressHistoryPK.setEmployeeId(empAddressPK.getEmployeeId());
		empAddressHistoryPK.setAddressType(empAddressPK.getAddressType());
		empAddressHistoryPK.setEntryTimestamp(LocalDateTime.now());
		empAddressHistory.setId(empAddressHistoryPK);
		
		return empAddressHistory;
	}
}
