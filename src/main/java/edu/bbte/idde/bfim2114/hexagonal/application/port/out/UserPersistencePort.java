package edu.bbte.idde.bfim2114.hexagonal.application.port.out;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;

import java.util.List;

public interface UserPersistencePort {

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    User save(User user);

    void deleteById(Long id);

    boolean existsById(Long id);
}
