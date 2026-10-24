package prakash.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import prakash.entity.Account;
import prakash.entity.TransferRecord;
import prakash.repository.AccountRepository;
import prakash.repository.TransferRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service

public class TransferService {
    private AccountRepository accountRepository;
    private TransferRepository transferRepository;
    public TransferService(AccountRepository accountRepository,TransferRepository transferRepository){
        this.accountRepository=accountRepository;
        this.transferRepository=transferRepository;
    }
    @Transactional
    public void transfer(Long fromAccoundId, Long toAccountId, BigDecimal amount){


        Account fromAccount = accountRepository.findById(fromAccoundId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
        accountRepository.saveAndFlush(fromAccount);
        toAccount.creditAccount(amount);
        accountRepository.saveAndFlush(toAccount);
        transferRepository.save(new TransferRecord(fromAccoundId,toAccountId,amount, LocalDate.now()));
        transferRepository.flush();
    }
}
