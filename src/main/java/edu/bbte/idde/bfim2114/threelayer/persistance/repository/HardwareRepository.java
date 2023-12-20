package edu.bbte.idde.bfim2114.threelayer.persistance.repository;

import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.HardwarePart;

public interface HardwareRepository extends BaseRepository<HardwarePart> {

    HardwarePart findByName(String partName);
}
