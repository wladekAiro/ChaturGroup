package com.wladek.realestate.repository;

import com.wladek.realestate.domain.realestate.Employee;
import com.wladek.realestate.domain.realestate.Employer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by george on 12/18/15.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee findByIdNumber(Long idNumber);
    public Page<Employee> findByEmployer(Employer employer , Pageable pageable);

}
