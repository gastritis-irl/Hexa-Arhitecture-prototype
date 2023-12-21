package edu.bbte.idde.bfim2114.hexagonal.application.domain.service.impl;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.UserSavePort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSaveService implements UserSavePort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public User create(User user) {
        return userPersistencePort.save(user);
    }

    @Override
    public void delete(Long userId) {
        userPersistencePort.deleteById(userId);
    }

    @Override
    public User update(User user) {
        return userPersistencePort.save(user);
    }

    @Override
    public boolean existsById(Long userId) {
        return userPersistencePort.existsById(userId);
    }
}
