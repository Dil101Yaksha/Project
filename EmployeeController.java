package com.Dileep.Springboot.Controller;


import com.Dileep.Springboot.Exception.ResourceNotFoundException;
import com.Dileep.Springboot.Model.Employee;
import com.Dileep.Springboot.Repository.Employee_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private Employee_Repository employee_repository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employee_repository.findAll();

    }

    //Build Create Employee Rest API

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employee_repository.save(employee);
    }
    // Build API to get employee by id

    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable long id){

        Employee employee = employee_repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
                return ResponseEntity.ok(employee);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployees(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee=employee_repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" +id));
        updateEmployee.setFirstName((employeeDetails.getFirstName()));
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailid(employeeDetails.getEmailid());
         employee_repository.save(updateEmployee);

         return ResponseEntity.ok(updateEmployee);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>deleteEmployee(@PathVariable long id){

        Employee employee=employee_repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id"+id));
        employee_repository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
