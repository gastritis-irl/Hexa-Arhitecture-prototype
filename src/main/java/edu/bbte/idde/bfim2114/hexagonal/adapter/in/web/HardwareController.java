package edu.bbte.idde.bfim2114.hexagonal.adapter.in.web;

import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.HardwarePartPresentationDTO;
import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.HardwarePartSaveDTO;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.mapper.HardwarePartMapper;
import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.HardwareDisplayPort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.HardwareSavePort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hardware")
public class HardwareController {

    private final HardwareSavePort hardwareSave;
    private final HardwareDisplayPort hardwareDisplay;
    private final HardwarePartMapper hardwarePartMapper;

    @GetMapping
    public ResponseEntity<Collection<HardwarePartPresentationDTO>> getAllHardwareParts() {
        log.info("GET: /api/hardware");
        return ResponseEntity.ok(hardwareDisplay.findAll().stream()
            .map(hardwarePartMapper::dtoToHardwarePart)
            .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<HardwarePartPresentationDTO> createHardwarePart(@Valid @RequestBody
                                                                          HardwarePartSaveDTO hardwarePartSaveDTO) {
        log.info("POST: /api/hardware");
        HardwarePart hardwarePart = hardwarePartMapper.hardwareParttoDTO(hardwarePartSaveDTO);
        return ResponseEntity.ok(hardwarePartMapper.dtoToHardwarePart(hardwareSave.create(hardwarePart)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardwarePartPresentationDTO> getHardwarePartById(@PathVariable Long id) {
        log.info("GET: /api/hardware/{}", id);
        if (hardwareDisplay.findById(id)==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hardwarePartMapper.dtoToHardwarePart(hardwareDisplay.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardwarePartPresentationDTO> updateHardwarePart(
        @PathVariable Long id,
        @Valid @RequestBody HardwarePartSaveDTO hardwarePartSaveDTO
    ) {
        log.info("PUT: /api/hardware/{}", id);
        HardwarePart hardwarePart = hardwarePartMapper.hardwareParttoDTO(hardwarePartSaveDTO);
        hardwarePart.setId(id);
        HardwarePart updatedHardwarePart = hardwareSave.update(hardwarePart);
        if (updatedHardwarePart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hardwarePartMapper.dtoToHardwarePart(updatedHardwarePart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardwarePart(@PathVariable Long id) {
        log.info("DELETE: /api/hardware/{}", id);
        hardwareSave.delete(id);
        return ResponseEntity.noContent().build();
    }
}
