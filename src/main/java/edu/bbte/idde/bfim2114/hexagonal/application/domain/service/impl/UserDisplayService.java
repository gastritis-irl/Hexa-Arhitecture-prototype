package edu.bbte.idde.bfim2114.hexagonal.application.domain.service.impl;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.UserDisplayPort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDisplayService implements UserDisplayPort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public User findByEmail(String username) {
        return userPersistencePort.findByEmail(username);
    }

    @Override
    public User findById(Long userId) {
        return userPersistencePort.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return userPersistencePort.findAll();
    }


}
