package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.mapper;

import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.HardwarePartSaveDTO;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity.HardwarePartJpaEntity;
import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.HardwarePartPresentationDTO;
import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.HardwarePart;
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

    HardwarePartJpaEntity hardwarePartToHardwarePartJpaEntity(HardwarePart hardwarePart);

    HardwarePart hardwarePartJpaEntityToHardwarePart(HardwarePartJpaEntity hardwarePartJpaEntity);
}
