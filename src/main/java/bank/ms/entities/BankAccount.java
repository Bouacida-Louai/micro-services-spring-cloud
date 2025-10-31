package bank.ms.entities;

import bank.ms.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Date CreatedAt;

    private Double balance;

    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;


}
