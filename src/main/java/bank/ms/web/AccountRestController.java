package bank.ms.web;

import bank.ms.Repository.BankAccountRepository;
import bank.ms.dtos.BankAccountRequestDto;
import bank.ms.dtos.BankAccountResponseDto;
import bank.ms.entities.BankAccount;

import bank.ms.service.AccountService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final AccountService accountService;

    private final BankAccountRepository bankAccountRepository;

    public AccountRestController(AccountService accountService, BankAccountRepository bankAccountRepository) {
        this.accountService = accountService;
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("bankAccounts/{id}")
    public BankAccount getAccountById(@PathVariable String id){
        return  bankAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account not fund"));
    }

    @PostMapping("/add/account")
    public BankAccountResponseDto addAccount(@RequestBody BankAccountRequestDto requestDto){
       return accountService.addAccount(requestDto);
    }

    @PutMapping("/update/account/{id}")
    public BankAccount updateAccount( @RequestBody BankAccount bankAccount,@PathVariable String id) {
        BankAccount existingAccount = bankAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account not fund"));
       if (bankAccount.getBalance()!=null)
           existingAccount.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency()!=null)
        existingAccount.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType()!=null)
        existingAccount.setType(bankAccount.getType());
        if (bankAccount.getCreatedAt()!=null)
        existingAccount.setCreatedAt(bankAccount.getCreatedAt());
        return bankAccountRepository.save(existingAccount);
    }

    @DeleteMapping("bankAccount/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }




}
