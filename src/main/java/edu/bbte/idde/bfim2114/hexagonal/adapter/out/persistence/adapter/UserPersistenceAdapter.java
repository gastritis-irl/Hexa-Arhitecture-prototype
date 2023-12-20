package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.adapter;

import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.mapper.UserMapper;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.repository.UserRepository;
import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;
import edu.bbte.idde.bfim2114.hexagonal.application.port.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User findByEmail(String email) {
        return userMapper.userJpaEntityToUser(userRepository.findByEmail(email));
    }

    @Override
    public User save(User user) {
        return userMapper.userJpaEntityToUser(userRepository.save(userMapper.userToUserJpaEntity(user)));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
