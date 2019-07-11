package de.sandbox.employees.service;

import de.sandbox.employees.model.Position;
import de.sandbox.employees.repository.PositionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> findAllPositions() {
        List<Position> positions = new ArrayList<>();
        positionRepository.findAll().forEach(positions::add);
        return positions;
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }
}
