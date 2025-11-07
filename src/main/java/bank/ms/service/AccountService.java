package bank.ms.service;

import bank.ms.dtos.BankAccountRequestDto;
import bank.ms.dtos.BankAccountResponseDto;
import bank.ms.entities.BankAccount;

public interface AccountService {

    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
    public BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountDto);


}
