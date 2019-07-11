package de.sandbox.employees.service;
import de.sandbox.employees.EmployeesApplication;
import de.sandbox.employees.exception.EmployeesException;
import de.sandbox.employees.model.Employee;
import de.sandbox.employees.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Transactional
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public final void setup() {
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void findEmployeeByIdTest() {
        Long id = 1L;
        assertEquals("Max", employeeService.findEmployeeById(id).getFirstName());
    }

    @Test(expected = EmployeesException.class)
    public void patchEmployeeTest() {
        Employee maxMustermannSupervisingHimself = new Employee();
        maxMustermannSupervisingHimself.setId(1L);

        Employee maxMustermann = new Employee();
        maxMustermann.setId(1L);

        maxMustermann.setSupervisor(maxMustermannSupervisingHimself);

        employeeService.patchEmployee(maxMustermann);
    }
}
