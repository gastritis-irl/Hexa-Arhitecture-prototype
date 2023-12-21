package edu.bbte.idde.bfim2114.hexagonal.application.port.out;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;

import java.util.List;
import java.util.Optional;

public interface HardwarePersistencePort {

    Optional<HardwarePart> findById(Long id);

    HardwarePart findByName(String name);

    HardwarePart save(HardwarePart part);

    void deleteById(Long id);

    List<HardwarePart> findAll();
}
