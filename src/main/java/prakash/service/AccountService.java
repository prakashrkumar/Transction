package prakash.service;

import org.springframework.stereotype.Service;
import prakash.entity.Account;
import prakash.repository.AccountRepository;
@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
}
