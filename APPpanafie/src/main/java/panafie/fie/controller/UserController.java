
package panafie.fie.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panafie.fie.dto.UserRegisterDTO;
import panafie.fie.dto.UserRoleUpdateDTO;
import panafie.fie.dto.UserStatusUpdateDTO;
import panafie.fie.model.role.Role;
import panafie.fie.model.user.User;
import panafie.fie.repository.UserRepository;

@RestController
@RequestMapping("/user/")
public class UserController {
    
    @Autowired
    public UserRepository userRepository;
    
    @PostMapping("/new")
    public ResponseEntity<?> newUser(@RequestBody @Valid UserRegisterDTO newUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error en los datos enviados");
        }
        Optional<User> findEmail = userRepository.findByEmail(newUserDTO.getEmail());
        if (findEmail.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo electrónico ya está en uso");
        } else {
            User newUser = new User();
            Role newRole = new Role();
            newRole.setId(2L);
            newUser.setRoleId(newRole);
            newUser.setName(newUserDTO.getName());
            newUser.setLastName(newUserDTO.getLastName());
            newUser.setStatus(1);
            newUser.setEmail(newUserDTO.getEmail());
            newUser.setPassword(newUserDTO.getPassword());

            User saved = userRepository.save(newUser);

            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }
    }
    
    @PostMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody @Valid User editUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error en los datos enviados");
        }
        Optional<User> editUserData = userRepository.findById(editUser.getId());
        if (editUserData.isPresent()) {
            User userEdit = editUserData.get();
            userEdit.setRoleId(editUser.getRoleId());
            userEdit.setName(editUser.getName());
            userEdit.setLastName(editUser.getLastName());
            userEdit.setStatus(editUser.getStatus());
            userEdit.setEmail(editUser.getEmail());
            userEdit.setPassword(editUser.getPassword());
            User saved = userRepository.save(userEdit);
            return ResponseEntity.ok(saved);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro usuario");
        }
    }
    
    @PostMapping("/edit/status")
    public ResponseEntity<?> editStatusUser(@RequestBody @Valid UserStatusUpdateDTO statusUpdate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error en los datos enviados");
        }
        Optional<User> user = userRepository.findById(statusUpdate.getId());
        if (user.isPresent()) {
            User editUser = user.get();
            editUser.setStatus(statusUpdate.getStatus());
            User saved = userRepository.save(editUser);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro usuario");

        }
    }
    
    @PostMapping("/edit/role")
    public ResponseEntity<?> editRoleUser(@RequestBody @Valid UserRoleUpdateDTO roleUpdate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error en los datos enviados");
        }
        Optional<User> user = userRepository.findById(roleUpdate.getId());
        if (user.isPresent()) {
            User editUser = user.get();
            editUser.setRoleId(roleUpdate.getRoleId());
            User saved = userRepository.save(editUser);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro usuario");

        }
    }
    
    @PostMapping("/all")
    public ResponseEntity<?> findAllUser() {
        List<User> users = userRepository.findByStatusNot(3);

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
}
