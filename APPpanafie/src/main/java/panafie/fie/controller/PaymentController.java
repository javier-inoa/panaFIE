package panafie.fie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panafie.fie.dto.PayDTO;
import panafie.fie.model.pay.Pay;
import panafie.fie.model.user.User;
import panafie.fie.repository.PaymentRepository;
import panafie.fie.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository payRepository;

    @Autowired
    private UserRepository userRepository;

    // Historia # GCO-07 - Pago de cuota
    // Realización del pago de cuota
    @PostMapping("/make-payment")
    public ResponseEntity<String> makePayment(@RequestBody PayDTO payDTO) {
        User user = userRepository.findById(payDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Lógica para verificar fondos insuficientes o permiso
        if (/* lógica para verificar saldo o permiso */ false) {
            return ResponseEntity.status(400).body("Error: Fondos insuficientes o falta de permiso");
        }

        Pay pay = new Pay();
        pay.setUserId(user);
        pay.setAmount(payDTO.getAmount());
        pay.setDate(payDTO.getDate());

        payRepository.save(pay);

        return ResponseEntity.ok("El pago fue procesado correctamente para el usuario: " +
                user.getNombre() + " " + user.getApellido() + ", Monto: " + pay.getAmount());
    }

    // Historia # GCO-07 - Pago de cuota
    // Selección de cuenta
    @GetMapping("/accounts/{userId}")
    public ResponseEntity<List<String>> getUserAccounts(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<String> accounts = List.of("Cuenta de Ahorros", "Cuenta Corriente");
            return ResponseEntity.ok(accounts);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Historia # GCO-07 - Pago de cuota
    // Confirmar el pago
    @PostMapping("/confirm-payment")
    public ResponseEntity<String> confirmPayment(@RequestBody PayDTO payDTO) {
        return ResponseEntity.ok("El pago se realizó correctamente para el usuario: " +
                payDTO.getUserId() + ", Monto: " + payDTO.getAmount());
    }

    // Historia # GCO-02 - Supervisación de actividades
    // Supervisar pagos de jugadores
    @GetMapping("/supervise")
    public ResponseEntity<List<Pay>> supervisePayments(@RequestParam String filter) {
        List<Pay> payments;
        switch (filter) {
            case "incomplete":
                payments = payRepository.findByIncompletePayments();
                break;
            case "overdue":
                payments = payRepository.findByDateBefore(new Date());
                break;
            case "all":
            default:
                payments = payRepository.findAll();
                break;
        }
        if (payments.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(payments);
    }
}
