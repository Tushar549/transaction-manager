package com.jar.transactionmanager.objects.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:22 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryResponse {
    String fromDate;
    String toDate;
    String mobileNumber;
    List<TransactionHistoryResponseHelper> transactionHistory;
}
