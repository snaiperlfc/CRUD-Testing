package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee("John Doe", "Engineering", 60000);
        Employee savedEmployee = employeeRepository.save(employee);
        assertNotNull(savedEmployee);
        assertEquals("John Doe", savedEmployee.getName());
    }

    @Test
    public void testGetEmployee() {
        Employee employee = employeeRepository.save(new Employee("Jane Doe", "Marketing", 70000));
        Employee fetchedEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        assertNotNull(fetchedEmployee);
        assertEquals(employee.getId(), fetchedEmployee.getId());
    }

    @Test
    public void testGetListOfEmployees() {
        employeeRepository.save(new Employee("John Doe", "Engineering", 60000));
        employeeRepository.save(new Employee("Jane Doe", "Marketing", 70000));
        List<Employee> employees = employeeRepository.findAll();
        assertNotNull(employees);
        assertEquals(2, employees.size());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = employeeRepository.save(new Employee("John Doe", "Engineering", 60000));
        employee.setName("John Smith");
        employeeRepository.save(employee);
        Employee updatedEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        assertNotNull(updatedEmployee);
        assertEquals("John Smith", updatedEmployee.getName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = employeeRepository.save(new Employee("John Doe", "Engineering", 60000));
        employeeRepository.deleteById(employee.getId());
        Employee deletedEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        assertNull(deletedEmployee);
    }
}

