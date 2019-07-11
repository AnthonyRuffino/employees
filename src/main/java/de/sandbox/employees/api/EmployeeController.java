package de.sandbox.employees.api;

import de.sandbox.employees.model.Employee;
import de.sandbox.employees.service.EmployeeService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable long id) {
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/position/{positionId}")
    public List<Employee> findEmployeesByPositionId(@PathVariable long positionId) {
        return employeeService.findEmployeesByPositionId(positionId);
    }

    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PatchMapping("/{id}")
    public Employee patchEmployee(@PathVariable long id, @RequestBody Employee employee) {
        throw new NotYetImplementedException();
    }
}
