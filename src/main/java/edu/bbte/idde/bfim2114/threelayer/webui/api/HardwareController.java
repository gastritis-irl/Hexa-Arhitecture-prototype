package edu.bbte.idde.bfim2114.threelayer.webui.api;

import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.HardwarePartPresentationDTO;
import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.HardwarePartSaveDTO;
import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.HardwarePart;
import edu.bbte.idde.bfim2114.threelayer.domain.model.mapper.HardwarePartMapper;
import edu.bbte.idde.bfim2114.threelayer.domain.service.HardwareService;

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

    private final HardwareService hardwareService;
    private final HardwarePartMapper hardwarePartMapper;

    @GetMapping
    public ResponseEntity<Collection<HardwarePartPresentationDTO>> getAllHardwareParts() {
        log.info("GET: /api/hardware");
        return ResponseEntity.ok(hardwareService.findAll().stream()
            .map(hardwarePartMapper::dtoToHardwarePart)
            .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<HardwarePartPresentationDTO> createHardwarePart(@Valid @RequestBody
                                                                 HardwarePartSaveDTO hardwarePartSaveDTO) {
        log.info("POST: /api/hardware");
        HardwarePart hardwarePart = hardwarePartMapper.hardwareParttoDTO(hardwarePartSaveDTO);
        return ResponseEntity.ok(hardwarePartMapper.dtoToHardwarePart(hardwareService.create(hardwarePart)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardwarePartPresentationDTO> getHardwarePartById(@PathVariable Long id) {
        log.info("GET: /api/hardware/{}", id);
        if (hardwareService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hardwarePartMapper.dtoToHardwarePart(hardwareService.findById(id).get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardwarePartPresentationDTO> updateHardwarePart(
        @PathVariable Long id,
        @Valid @RequestBody HardwarePartSaveDTO hardwarePartSaveDTO
    ) {
        log.info("PUT: /api/hardware/{}", id);
        HardwarePart hardwarePart = hardwarePartMapper.hardwareParttoDTO(hardwarePartSaveDTO);
        hardwarePart.setId(id);
        HardwarePart updatedHardwarePart = hardwareService.update(hardwarePart);
        if (updatedHardwarePart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hardwarePartMapper.dtoToHardwarePart(updatedHardwarePart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardwarePart(@PathVariable Long id) {
        log.info("DELETE: /api/hardware/{}", id);
        hardwareService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
