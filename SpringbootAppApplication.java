package com.Dileep.Springboot;

import com.Dileep.Springboot.Model.Employee;
import com.Dileep.Springboot.Repository.Employee_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

	@Autowired
	private Employee_Repository employee_repository;


	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setFirstName("Dileep");
		employee.setLastName("Kumar");
		employee.setEmailid("dileep@gmail.com");
		employee_repository.save(employee);

		Employee employee1=new Employee();
		employee1.setFirstName("Yaksha");
		employee1.setLastName("Raja");
		employee1.setEmailid("dilyaksha@gmail.com");
		employee_repository.save(employee1);

	}
}
