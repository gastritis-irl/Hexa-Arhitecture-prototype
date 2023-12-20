package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.repository;

import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity.HardwarePartJpaEntity;

public interface HardwareRepository extends BaseRepository<HardwarePartJpaEntity> {

    HardwarePartJpaEntity findByName(String partName);
}
