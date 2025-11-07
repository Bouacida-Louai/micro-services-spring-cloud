package bank.ms;

import bank.ms.Repository.BankAccountRepository;
import bank.ms.Repository.CustomerRepository;
import bank.ms.entities.BankAccount;
import bank.ms.entities.Customer;
import bank.ms.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankMicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Louai","Zaki","Ahmed").forEach(c->{
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer->{
                for (int i = 1; i <= 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(Math.random() * 9000)
                            .currency("USD")
                            .customer(customer)
                            .CreatedAt(new Date())
                            .type(Math.random() > 0.5 ? AccountType.SAVINGS_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });

        };
    }
}
