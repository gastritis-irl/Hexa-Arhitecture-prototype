package edu.bbte.idde.bfim2114.hexagonal.adapter.in.web;


import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.UserSaveDTO;
import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.UserPresentationDTO;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.mapper.UserMapper;
import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.UserDisplayPort;
import edu.bbte.idde.bfim2114.hexagonal.application.port.in.UserSavePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserDisplayPort userDisplay;
    private final UserSavePort userSave;
    private final UserMapper userMapper;

    @GetMapping("/{username}")
    public ResponseEntity<UserPresentationDTO> getUserByUsername(@PathVariable String username) {
        log.info("GET: /api/users/{}", username);
        User user = userDisplay.findByEmail(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.userToDTo(user));
    }

    @PostMapping
    public ResponseEntity<UserPresentationDTO> createUser(@Valid @RequestBody UserSaveDTO userSaveDTO) {
        log.info("POST: /api/users");
        User user = userMapper.dtoToUser(userSaveDTO);
        return ResponseEntity.ok(userMapper.userToDTo(userSave.create(user)));
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserPresentationDTO> updateUser(@PathVariable String username,
                                                          @Valid @RequestBody UserSaveDTO userSaveDTO) {
        log.info("PUT: /api/users/{}", username);
        User user = userMapper.dtoToUser(userSaveDTO);
        User updated = userSave.update(user);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.userToDTo(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("DELETE: /api/users/{}", id);
        userSave.delete(id);
        return ResponseEntity.noContent().build();
    }
}
