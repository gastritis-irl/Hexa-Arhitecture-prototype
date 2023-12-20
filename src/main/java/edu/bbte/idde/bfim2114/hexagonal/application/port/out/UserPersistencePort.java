package edu.bbte.idde.bfim2114.hexagonal.application.port.out;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;

public interface UserPersistencePort {

    User findByEmail(String email);

    User save(User user);

    void deleteById(Long id);

    boolean existsById(Long id);
}
