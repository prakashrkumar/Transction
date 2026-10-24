package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prakash.entity.Account;
import prakash.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }
    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody Account account){
        if(account.getName() == null || account.getName().isBlank() || account.getBalance() == null){
            return ResponseEntity.badRequest().body("name and balance are required");
        }
        return ResponseEntity.ok(accountService.createAccount(account));
    }
}
