package de.sandbox.employees.repository;

import de.sandbox.employees.model.Position;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PositionRepository extends PagingAndSortingRepository<Position, Long> {
}
