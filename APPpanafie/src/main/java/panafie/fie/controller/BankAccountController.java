package panafie.fie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panafie.fie.model.bankaccount.BankAccount;
import panafie.fie.repository.BankAccountRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bankAccounts")
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;

    // Obtener todas las cuentas bancarias
    @PostMapping("/getAll")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        List<BankAccount> result = bankAccountRepository.findAll();
        return ResponseEntity.ok(result);
    }

    // Obtener una cuenta bancaria por ID
    @PostMapping("/getById")
    public ResponseEntity<BankAccount> getBankAccountById(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        return bankAccount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva cuenta bancaria
    @PostMapping("/create")
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        BankAccount createdBankAccount = bankAccountRepository.save(bankAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBankAccount);
    }

    // Actualizar una cuenta bancaria existente
    @PostMapping("/update")
    public ResponseEntity<BankAccount> updateBankAccount(@RequestBody BankAccount bankAccountDetails) {
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(bankAccountDetails.getId());
        if (!bankAccountOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        BankAccount bankAccount = bankAccountOptional.get();
        bankAccount.setUserId(bankAccountDetails.getUserId());
        bankAccount.setAccountNumber(bankAccountDetails.getAccountNumber());
        bankAccount.setBank(bankAccountDetails.getBank());
        bankAccount.setBalance(bankAccountDetails.getBalance());

        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        return ResponseEntity.ok(updatedBankAccount);
    }

    // Eliminar una cuenta bancaria
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteBankAccount(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if (!bankAccount.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        bankAccountRepository.delete(bankAccount.get());
        return ResponseEntity.noContent().build();
    }
}