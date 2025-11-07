package bank.ms.mappers;

import bank.ms.dtos.BankAccountRequestDto;
import bank.ms.dtos.BankAccountResponseDto;
import bank.ms.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
public class BankAccountMapper {


   public BankAccount fromRequestToEntity(BankAccountRequestDto bankAccountRequestDto){
       BankAccount bankAccount=new BankAccount();
       BeanUtils.copyProperties(bankAccountRequestDto,bankAccount);
       bankAccount.setId(java.util.UUID.randomUUID().toString());
       bankAccount.setCreatedAt(new Date());
       return bankAccount;
   }

   public BankAccountResponseDto fromEntityToResponse(BankAccount bankAccount){
       BankAccountResponseDto bankAccountResponseDto=new BankAccountResponseDto();
       BeanUtils.copyProperties(bankAccount,bankAccountResponseDto);
       return bankAccountResponseDto;
   }
}

