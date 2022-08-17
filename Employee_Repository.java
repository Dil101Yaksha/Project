package com.Dileep.Springboot.Repository;

import com.Dileep.Springboot.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employee_Repository extends JpaRepository<Employee, Long> {
    // all crud database
}
