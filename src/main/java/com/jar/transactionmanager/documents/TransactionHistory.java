package com.jar.transactionmanager.documents;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:18 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Getter
@Setter
@Builder
@ToString
@Document(collection = "transaction_history")
public class TransactionHistory {
    @Id
    String transactionId;
    String mobileNumber;
    Double amountInINR;
    String transactionType;
    String transactionCurrency;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
