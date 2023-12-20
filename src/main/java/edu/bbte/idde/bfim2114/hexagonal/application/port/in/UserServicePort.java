package edu.bbte.idde.bfim2114.hexagonal.application.port.in;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;

public interface UserServicePort {

    User findByUsername(String username);

    User create(User user);

    User update(User user);

    void delete(Long id);

    boolean isAdmin(String username);

    boolean existsById(Long id);
}
