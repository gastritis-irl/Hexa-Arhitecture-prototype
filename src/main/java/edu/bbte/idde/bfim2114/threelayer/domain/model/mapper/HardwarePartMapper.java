package edu.bbte.idde.bfim2114.threelayer.domain.model.mapper;

import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.HardwarePartSaveDTO;
import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.HardwarePart;
import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.HardwarePartPresentationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface HardwarePartMapper {
    @Mapping(source = "userId", target = "user.id")
    HardwarePart hardwareParttoDTO(HardwarePartSaveDTO hardwarePartSaveDTO);

    @Mapping(source = "user.id", target = "userId")
    HardwarePartPresentationDTO dtoToHardwarePart(HardwarePart hardwarePart);

    Collection<HardwarePartPresentationDTO> hardwareParttoOuts(Collection<HardwarePart> parts);
}
