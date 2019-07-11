package de.sandbox.employees.api;

import de.sandbox.employees.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/employee")
@RestController
public class EmployeeController {

    private static Employee mockEmployee = new Employee();
    static {
        mockEmployee.setFirstName("fn");
        mockEmployee.setLastName("ln");
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return Arrays.asList(mockEmployee);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable long id) {
        return mockEmployee;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable long id) {

    }

    @GetMapping("/position/{positionId}")
    public List<Employee> findEmployeesByPositionId(@PathVariable long positionId) {
        return Arrays.asList(mockEmployee);
    }

    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee) {
        return mockEmployee;
    }

    @PatchMapping("/{id}")
    public Employee patchEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setId(id);
        return mockEmployee;
    }
}
