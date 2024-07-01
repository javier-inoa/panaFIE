package panaFIE.panaFIE.controller.player;

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
import panaFIE.panaFIE.dto.UserEditPlayerDTO;
import panaFIE.panaFIE.dto.UserRegisterDTO;
import panaFIE.panaFIE.model.Role;
import panaFIE.panaFIE.model.User;
import panaFIE.panaFIE.repository.UserRepository;

@RestController
@RequestMapping(value = "/player/user/")
public class PlayerUserController {

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
            newRole.setId(3L);
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
    public ResponseEntity<?> editUser(@RequestBody @Valid UserEditPlayerDTO editUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error en los datos enviados");
        }
        Optional<User> editUserData = userRepository.findById(editUser.getId());
        if (editUserData.isPresent()) {
            Optional<User> findEmail = userRepository.findByEmail(editUser.getEmail());
            if (findEmail.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo electrónico ya está en uso");
            } else {
                User userEdit = editUserData.get();
                userEdit.setName(editUser.getName());
                userEdit.setLastName(editUser.getLastName());
                userEdit.setEmail(editUser.getEmail());
                userEdit.setPassword(editUser.getPassword());
                User saved = userRepository.save(userEdit);
                return ResponseEntity.ok(saved);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro usuario");
        }
    }
}
