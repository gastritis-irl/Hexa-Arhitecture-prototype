package edu.bbte.idde.bfim2114.hexagonal.application.port.in;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;

public interface HardwareSavePort {

    HardwarePart create(HardwarePart part);

    void delete(Long partId);

    HardwarePart update(HardwarePart part);

    boolean isValid(HardwarePart part);
}
