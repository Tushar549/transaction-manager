package com.jar.transactionmanager.objects.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 8:08 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryResponseHelper {
    String transactionId;
    Double amount;
    String amountCurrency;
    String transactionType;
    String transactionCurrency;
    LocalDateTime transactionDateTime;
}
