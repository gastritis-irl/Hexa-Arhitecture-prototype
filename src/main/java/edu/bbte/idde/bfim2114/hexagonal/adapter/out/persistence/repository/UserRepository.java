package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.repository;

import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity.UserJpaEntity;

public interface UserRepository extends BaseRepository<UserJpaEntity> {

    UserJpaEntity findByEmail(String username);
}
