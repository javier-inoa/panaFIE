package panafie.fie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panafie.fie.dto.PayDTO;
import panafie.fie.model.pay.Pay;
import panafie.fie.model.user.User;
import panafie.fie.repository.PaymentRepository;
import panafie.fie.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository payRepository;

    @Autowired
    private UserRepository userRepository;

    // Create
    @PostMapping("/register")
    public ResponseEntity<String> registerPayment(@RequestBody PayDTO payDTO) {
        User user = userRepository.findById(payDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Pay pay = new Pay();
        pay.setUserId(user);
        pay.setAmount(payDTO.getAmount());
        pay.setDate(payDTO.getDate());

        payRepository.save(pay);

        return ResponseEntity.ok("Payment registered successfully");
    }

    @GetMapping
    public List<Pay> getAllPayments() {
        return payRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pay> getPaymentById(@PathVariable Long id) {
        Optional<Pay> pay = payRepository.findById(id);
        return pay.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable Long id, @RequestBody PayDTO payDTO) {
        Optional<Pay> optionalPay = payRepository.findById(id);
        if (optionalPay.isPresent()) {
            Pay pay = optionalPay.get();
            User user = userRepository.findById(payDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            pay.setUserId(user);
            pay.setAmount(payDTO.getAmount());
            pay.setDate(payDTO.getDate());
            payRepository.save(pay);

            return ResponseEntity.ok("Payment updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        if (payRepository.existsById(id)) {
            payRepository.deleteById(id);
            return ResponseEntity.ok("Payment deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

