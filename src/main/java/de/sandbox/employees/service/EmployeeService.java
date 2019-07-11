package de.sandbox.employees.service;

import de.sandbox.employees.model.Employee;
import de.sandbox.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findOneById(id).orElseThrow(() -> new RuntimeException("No such employee id: " + id));
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.findAllBySupervisorId(id).forEach(employee -> {
            employee.setSupervisor(null);
        });
        employeeRepository.deleteById(id);
    }

    public List<Employee> findEmployeesByPositionId(Long positionId) {
        return employeeRepository.findAllByPositionId(positionId);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    private void updateSupervisor(Employee employee, Employee newSupervisor) {
        employee.setSupervisor(newSupervisor);
    }
}
