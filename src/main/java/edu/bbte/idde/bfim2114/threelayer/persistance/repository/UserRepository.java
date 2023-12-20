package edu.bbte.idde.bfim2114.threelayer.persistance.repository;

import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.User;

public interface UserRepository extends BaseRepository<User> {

    User findByEmail(String username);
}
