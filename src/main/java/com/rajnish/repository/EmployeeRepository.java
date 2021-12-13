package com.rajnish.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rajnish.model.*;
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{

}
