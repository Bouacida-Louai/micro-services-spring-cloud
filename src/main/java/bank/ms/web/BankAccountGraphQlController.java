package bank.ms.web;

import bank.ms.Repository.BankAccountRepository;
import bank.ms.Repository.CustomerRepository;
import bank.ms.dtos.BankAccountRequestDto;
import bank.ms.dtos.BankAccountResponseDto;
import bank.ms.entities.BankAccount;
import bank.ms.entities.Customer;
import bank.ms.mappers.BankAccountMapper;
import bank.ms.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;



@Controller
public class BankAccountGraphQlController {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;
    private final AccountService accountService;
    private final CustomerRepository customerRepository;

    public BankAccountGraphQlController(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper, AccountService accountService, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccountDto) {
        return accountService.addAccount(bankAccountDto);
    }

    @MutationMapping
    public BankAccountResponseDto update(@Argument String id,@Argument BankAccountRequestDto bankAccountDto) {
        return accountService.addAccount(bankAccountDto);
    }
    @MutationMapping
    public boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}
