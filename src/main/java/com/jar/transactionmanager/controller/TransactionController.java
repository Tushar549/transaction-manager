package com.jar.transactionmanager.controller;

import com.jar.transactionmanager.controller.docs.ITransactionController;
import com.jar.transactionmanager.objects.GlobalApiResponse;
import com.jar.transactionmanager.objects.constants.Endpoints;
import com.jar.transactionmanager.objects.constants.StringConstants;
import com.jar.transactionmanager.objects.requests.RecordTransactionRequest;
import com.jar.transactionmanager.objects.response.RecordTransactionResponse;
import com.jar.transactionmanager.objects.response.TransactionHistoryResponse;
import com.jar.transactionmanager.service.docs.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:15 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */
@RestController
@RequestMapping(Endpoints.TRANSACTION_MANAGER)
public class TransactionController implements ITransactionController {
    @Autowired
    ITransactionService iTransactionService;

    @Override
    public ResponseEntity<GlobalApiResponse> recordTransaction(String mobileNumber, RecordTransactionRequest recordTransactionRequest) {
        RecordTransactionResponse response = iTransactionService.recordTransaction(mobileNumber, recordTransactionRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GlobalApiResponse
                        .builder()
                        .apiResponseCode(StringConstants.SUCCESS_CODE)
                        .apiResponseMessage("Transaction recorded successfully.")
                        .apiResponseBody(response)
                        .build()
                );
    }

    @Override
    public ResponseEntity<GlobalApiResponse> getTransactionHistory(String mobileNumber, String fromDate, String toDate, String currency) {
        TransactionHistoryResponse response = iTransactionService.getTransactionHistory(mobileNumber, fromDate, toDate, currency);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GlobalApiResponse
                        .builder()
                        .apiResponseCode(StringConstants.SUCCESS_CODE)
                        .apiResponseMessage("Transaction History fetched successfully.")
                        .apiResponseBody(response)
                        .build()
                );
    }
}
