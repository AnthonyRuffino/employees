package de.sandbox.employees.service;

import de.sandbox.employees.exception.EmployeesException;
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

    public Employee patchEmployee(Employee employee) {
        //TODO implement more patching support later.  For now we only want to use this endpoint to set the supervisor.
        // We will likely have to use a Map as the input instead of an Employee at that time and then target only the
        // fields present in the map
        Employee attachedEmployee = findEmployeeById(employee.getId());
        updateSupervisor(attachedEmployee, employee.getSupervisor());
        return employeeRepository.save(attachedEmployee);
    }

    private void updateSupervisor(Employee employee, Employee newSupervisor) {
        Employee supervisor = null;
        if (newSupervisor != null && newSupervisor.getId() != null) {
            supervisor = validateSupervisor(newSupervisor.getId(), employee);
        }
        employee.setSupervisor(supervisor);
    }

    private Employee validateSupervisor(Long supervisorId) {
        Employee supervisor = findEmployeeById(supervisorId);
        if (!supervisor.getPosition().isSupervisor()) {
            throw new EmployeesException("Employee not in a supervisory role: " + supervisor.getId());
        }
        return supervisor;
    }

    private Employee validateSupervisor(Long supervisorId, Employee employee) {
        Employee supervisor = validateSupervisor(supervisorId);
        if(supervisor.getId().equals(employee.getId())) {
            throw new EmployeesException("Employees may not supervise themselves!");
        }
        return supervisor;
    }
}
