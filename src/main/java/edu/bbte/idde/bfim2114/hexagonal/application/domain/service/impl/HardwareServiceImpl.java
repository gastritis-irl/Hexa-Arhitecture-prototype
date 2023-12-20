package edu.bbte.idde.bfim2114.hexagonal.application.domain.service.impl;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.HardwareServicePort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.UserServicePort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.HardwarePersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HardwareServiceImpl implements HardwareServicePort {

    private final HardwarePersistencePort hardwarePersistencePort;
    private final UserServicePort userService;

    @Override
    public HardwarePart findByName(String partName) {

        log.info("Finding HardwarePartJpaEntity by name: {}", partName);
        return hardwarePersistencePort.findByName(partName);
    }

    @Override
    public Optional<HardwarePart> findById(Long partId) {

        log.info("Finding HardwarePartJpaEntity by id: {}", partId);
        return hardwarePersistencePort.findById(partId);
    }

    @Override
    public boolean isValid(HardwarePart part) {
        if (part == null) {
            log.error("HardwarePartJpaEntity is null so it is invalid");
            return true;
        }
        Long userId = part.getUser().getId();

        return !userService.existsById(userId) || part.getName() == null
            || part.getName().isEmpty();
    }

    @Override
    public HardwarePart create(HardwarePart part) {
        if (isValid(part)) {
            log.error("Invalid HardwarePartJpaEntity");
            throw new IllegalArgumentException("Invalid HardwarePartJpaEntity");
        }

        log.info("Creating HardwarePartJpaEntity: {}", part);
        return hardwarePersistencePort.save(part);
    }

    @Transactional
    @Override
    public void delete(Long partId) {

        log.info("Deleting HardwarePartJpaEntity by id: {}", partId);
        hardwarePersistencePort.deleteById(partId);
    }

    @Transactional
    @Override
    public HardwarePart update(HardwarePart part) {
        if (isValid(part)) {
            log.error("Invalid HardwarePartJpaEntity");
            throw new IllegalArgumentException("Invalid HardwarePartJpaEntity");
        }
        log.info("Updating HardwarePartJpaEntity: {}", part);
        return hardwarePersistencePort.save(part);
    }

    @Override
    public List<HardwarePart> findAll() {

        log.info("Finding all HardwareParts");
        return hardwarePersistencePort.findAll();
    }
}
