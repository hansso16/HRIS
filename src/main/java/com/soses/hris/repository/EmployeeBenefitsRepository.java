package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.EmployeeBenefits;

/**
 * The Interface EmployeeBenefitsRepository.
 *
 * @author hso
 * @since 19 Nov 2021
 */
public interface EmployeeBenefitsRepository extends JpaRepository<EmployeeBenefits, String> {

	/**
	 * Find by employee id.
	 *
	 * @param employeeId the employee id
	 * @return the employee benefits
	 */
	EmployeeBenefits findByEmployeeId(String employeeId);
}
