package de.sandbox.employees.repository;

import de.sandbox.employees.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Optional<Employee> findOneById(Long id);
    List<Employee> findAllByPositionId(Long positionId);
    List<Employee> findAllBySupervisorId(Long supervisorId);
}
