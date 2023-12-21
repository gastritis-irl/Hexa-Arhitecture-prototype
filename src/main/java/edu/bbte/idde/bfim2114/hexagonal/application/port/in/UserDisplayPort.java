package edu.bbte.idde.bfim2114.hexagonal.application.port.in;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;

import java.util.List;

public interface UserDisplayPort {

        List<User> findAll();

        User findById(Long userId);

        User findByEmail(String email);
}
