package edu.bbte.idde.bfim2114.threelayer.webui.api;


import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.UserSaveDTO;
import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.UserPresentationDTO;
import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.User;
import edu.bbte.idde.bfim2114.threelayer.domain.model.mapper.UserMapper;
import edu.bbte.idde.bfim2114.threelayer.domain.service.UserService;
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

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{username}")
    public ResponseEntity<UserPresentationDTO> getUserByUsername(@PathVariable String username) {
        log.info("GET: /api/users/{}", username);
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.userToDTo(user));
    }

    @PostMapping
    public ResponseEntity<UserPresentationDTO> createUser(@Valid @RequestBody UserSaveDTO userSaveDTO) {
        log.info("POST: /api/users");
        User user = userMapper.dtoToUser(userSaveDTO);
        return ResponseEntity.ok(userMapper.userToDTo(userService.create(user)));
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserPresentationDTO> updateUser(@PathVariable String username,
                                                          @Valid @RequestBody UserSaveDTO userSaveDTO) {
        log.info("PUT: /api/users/{}", username);
        User user = userMapper.dtoToUser(userSaveDTO);
        User updatedUser = userService.update(user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.userToDTo(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("DELETE: /api/users/{}", id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
