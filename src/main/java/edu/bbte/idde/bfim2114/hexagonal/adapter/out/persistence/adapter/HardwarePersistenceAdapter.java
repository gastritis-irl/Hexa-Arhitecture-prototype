package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.adapter;

import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.mapper.HardwarePartMapper;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.repository.HardwareRepository;
import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.HardwarePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HardwarePersistenceAdapter implements HardwarePersistencePort {

    private final HardwareRepository hardwareRepository;
    private final HardwarePartMapper hardwareMapper;

    @Override
    public Optional<HardwarePart> findById(Long id) {
        return hardwareRepository.findById(id).map(hardwareMapper::hardwarePartJpaEntityToHardwarePart);
    }

    @Override
    public HardwarePart findByName(String name) {
        return hardwareMapper.hardwarePartJpaEntityToHardwarePart(hardwareRepository.findByName(name));
    }

    @Override
    public HardwarePart save(HardwarePart part) {
        return hardwareMapper.hardwarePartJpaEntityToHardwarePart(hardwareRepository.save(hardwareMapper.hardwarePartToHardwarePartJpaEntity(part)));
    }

    @Override
    public void deleteById(Long id) {
        hardwareRepository.deleteById(id);
    }

    @Override
    public List<HardwarePart> findAll() {
        return hardwareRepository.findAll().stream().map(hardwareMapper::hardwarePartJpaEntityToHardwarePart).toList();
    }
}
