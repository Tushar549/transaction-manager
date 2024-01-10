package com.jar.transactionmanager.service.docs;

import com.jar.transactionmanager.objects.requests.RecordTransactionRequest;
import com.jar.transactionmanager.objects.response.RecordTransactionResponse;
import com.jar.transactionmanager.objects.response.TransactionHistoryResponse;
import org.springframework.stereotype.Service;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:17 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

public interface ITransactionService {

    public RecordTransactionResponse recordTransaction(String mobileNumber, RecordTransactionRequest recordTransactionRequest);
    public TransactionHistoryResponse getTransactionHistory(String mobileNumber, String fromDate, String toDate, String currency);

}
