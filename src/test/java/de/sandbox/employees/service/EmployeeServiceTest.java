package de.sandbox.employees.service;
import de.sandbox.employees.model.Employee;
import de.sandbox.employees.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    private static Employee MOCK_EMPLOYEE = new Employee();
    static {
        MOCK_EMPLOYEE.setId(1L);
        MOCK_EMPLOYEE.setFirstName("Mocky");
        MOCK_EMPLOYEE.setLastName("Mock");
    }



    @Before
    public final void setup() {
        employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findOneById(1L)).thenReturn(Optional.of(MOCK_EMPLOYEE));
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void findEmployeeByIdTest() {
        Long id = 1L;
        assertEquals(id, employeeService.findEmployeeById(id).getId());
    }
}
