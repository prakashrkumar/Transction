package prakash.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class TransferRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonProperty("fromAccountId")
    @JsonAlias("fromAccountID")
    private Long fromAccountId;

    @JsonProperty("toAccountId")
    @JsonAlias({"toAccountID", "toAccoundId"})
    private  Long toAccountId;

    @JsonProperty("amount")
    private BigDecimal amount;
    private LocalDate transferredAt;

    public TransferRecord(Long fromAccountId,Long toAccountId,BigDecimal amount,LocalDate transferredAt){
        this.fromAccountId=fromAccountId;
        this.toAccountId=toAccountId;
        this.amount=amount;
        this.transferredAt=transferredAt;
    }



}
