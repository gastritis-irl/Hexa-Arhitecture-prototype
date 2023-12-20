package edu.bbte.idde.bfim2114.threelayer.domain.service.impl;

import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.User;
import edu.bbte.idde.bfim2114.threelayer.domain.service.UserService;
import edu.bbte.idde.bfim2114.threelayer.persistance.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User findByUsername(String username) {

        log.info("Finding User by username: {}", username);
        return userRepository.findByEmail(username);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public User create(User user) {

        log.info("Creating User: {}", user);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {

        log.info("Updating User: {}", user);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {

        log.info("Deleting User by id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public boolean isAdmin(String username) {
        return "admin".equals(username);
    }
}
