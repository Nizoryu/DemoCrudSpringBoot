package fr.formation.inti.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.inti.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
