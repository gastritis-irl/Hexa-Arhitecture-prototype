package edu.bbte.idde.bfim2114.hexagonal.application.domain.service.impl;

import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.UserServicePort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.UserPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServicePort {

    private final UserPersistencePort userPersistencePort;


    @Override
    public User findByUsername(String username) {

        log.info("Finding UserJpaEntity by username: {}", username);
        return userPersistencePort.findByEmail(username);
    }

    @Override
    public boolean existsById(Long id) {
        return userPersistencePort.existsById(id);
    }

    @Override
    public User create(User user) {

        log.info("Creating UserJpaEntity: {}", user);
        return userPersistencePort.save(user);
    }

    @Override
    public User update(User user) {

        log.info("Updating UserJpaEntity: {}", user);
        return userPersistencePort.save(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {

        log.info("Deleting UserJpaEntity by id: {}", id);
        userPersistencePort.deleteById(id);
    }

    @Override
    public boolean isAdmin(String username) {
        return "admin".equals(username);
    }
}
