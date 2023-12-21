package edu.bbte.idde.bfim2114.hexagonal.application.port.in;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;

import java.util.List;

public interface HardwareDisplayPort {

    List<HardwarePart> findAll();

    HardwarePart findById(Long partId);

    HardwarePart findByName(String partName);
}
