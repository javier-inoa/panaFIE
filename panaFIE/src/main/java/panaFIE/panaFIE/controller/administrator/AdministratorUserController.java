package panaFIE.panaFIE.controller.administrator;

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
import panaFIE.panaFIE.dto.UserRegisterDTO;
import panaFIE.panaFIE.model.Role;
import panaFIE.panaFIE.model.User;
import panaFIE.panaFIE.repository.RoleRepository;
import panaFIE.panaFIE.repository.UserRepository;

@RestController
@RequestMapping(value = "/administrator/user")
public class AdministratorUserController {

    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@RequestBody @Valid UserRegisterDTO newUserDTO) {
        Optional<Role> role = roleRepository.findById(2L);
        User newUser = new User();
        newUser.setRoleId(role.get());
        newUser.setName(newUserDTO.getName());
        newUser.setLastName(newUserDTO.getLastName());
        newUser.setStatus(1);
        newUser.setEmail(newUserDTO.getEmail());
        newUser.setPassword(newUserDTO.getPassword());

        User saved = userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
