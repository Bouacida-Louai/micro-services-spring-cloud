package bank.ms.service;

import bank.ms.Repository.BankAccountRepository;
import bank.ms.dtos.BankAccountRequestDto;
import bank.ms.dtos.BankAccountResponseDto;
import bank.ms.entities.BankAccount;
import bank.ms.mappers.BankAccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepository bankAccountRepository ;
    private final BankAccountMapper bankAccountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {

        BankAccount bankAccount =bankAccountMapper.fromRequestToEntity(bankAccountDto);

        BankAccount savedBankAccount= bankAccountRepository.save(bankAccount);

        return bankAccountMapper.fromEntityToResponse(savedBankAccount);
    }
    @Override
    public BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountDto) {

        BankAccount bankAccount =bankAccountMapper.fromRequestToEntity(bankAccountDto);

        BankAccount savedBankAccount= bankAccountRepository.save(bankAccount);

        return bankAccountMapper.fromEntityToResponse(savedBankAccount);
    }
}
