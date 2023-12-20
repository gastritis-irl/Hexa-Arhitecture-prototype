package edu.bbte.idde.bfim2114.hexagonal.application.domain.service.impl;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.HardwareDisplayPort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.HardwarePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HardwareDisplayService implements HardwareDisplayPort {

    private final HardwarePersistencePort hardwarePersistencePort;

    @Override
    public List<HardwarePart> findAll() {
        return hardwarePersistencePort.findAll();
    }

    @Override
    public HardwarePart findById(Long partId) {
        return hardwarePersistencePort.findById(partId).orElse(null);
    }

    @Override
    public HardwarePart findByName(String partName) {
        return hardwarePersistencePort.findByName(partName);
    }
}
