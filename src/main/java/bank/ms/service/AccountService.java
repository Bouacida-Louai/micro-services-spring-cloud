package bank.ms.service;

import bank.ms.dtos.BankAccountDto;
import bank.ms.entities.BankAccount;

public interface AccountService {
     public BankAccountDto addAccount(BankAccountDto bankAccountResponseDto);
}
