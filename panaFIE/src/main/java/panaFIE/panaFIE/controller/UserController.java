package panaFIE.panaFIE.controller;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import panaFIE.panaFIE.model.User;
import panaFIE.panaFIE.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository callUser;

    @PostMapping("/login")
    public ResponseEntity<?> findUser(@RequestBody Map<String, String> datos) {
        String email = datos.get("email");
        String password = datos.get("password");

        Optional<User> user = callUser.findByEmailAndPassword(email, password);
        if (user.isPresent()) {
            User userModel = user.get();
            int userStatus = userModel.getStatus();
            if (userStatus != 3) {
                return ResponseEntity.ok(userModel);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
