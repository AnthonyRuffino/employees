package de.sandbox.employees.api;

import de.sandbox.employees.model.Employee;
import de.sandbox.employees.model.Position;
import de.sandbox.employees.service.PositionService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/position")
@RestController
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("")
    public List<Position> findAllPositions() {
        return positionService.findAllPositions();
    }
}
