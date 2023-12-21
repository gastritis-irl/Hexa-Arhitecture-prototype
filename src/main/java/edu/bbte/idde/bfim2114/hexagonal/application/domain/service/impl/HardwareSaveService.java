package edu.bbte.idde.bfim2114.hexagonal.application.domain.service.impl;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.HardwareSavePort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.UserSavePort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.HardwarePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HardwareSaveService implements HardwareSavePort {

    private final HardwarePersistencePort hardwarePersistencePort;
    private final UserSavePort userSave;

    @Override
    public HardwarePart create(HardwarePart part) {
        return hardwarePersistencePort.save(part);
    }

    @Override
    public void delete(Long partId) {
        hardwarePersistencePort.deleteById(partId);
    }

    @Override
    public HardwarePart update(HardwarePart part) {
        return hardwarePersistencePort.save(part);
    }

    @Override
    public boolean isValid(HardwarePart part) {
        if (part == null) {
            return true;
        }
        Long userId = part.getUser().getId();

        return !userSave.existsById(userId) || part.getName() == null
            || part.getName().isEmpty();
    }
}
