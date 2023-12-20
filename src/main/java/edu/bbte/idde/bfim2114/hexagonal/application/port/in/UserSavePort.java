package edu.bbte.idde.bfim2114.hexagonal.application.port.in;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;

public interface UserSavePort {

    User create(User user);

    void delete(Long userId);

    User update(User user);

    boolean existsById(Long userId);
}
