package com.jar.transactionmanager.service;

import com.jar.transactionmanager.documents.TransactionHistory;
import com.jar.transactionmanager.objects.enums.CurrencyEnum;
import com.jar.transactionmanager.objects.requests.RecordTransactionRequest;
import com.jar.transactionmanager.objects.response.RecordTransactionResponse;
import com.jar.transactionmanager.objects.response.TransactionHistoryResponse;
import com.jar.transactionmanager.repository.TransactionHistoryRepo;
import com.jar.transactionmanager.service.docs.ITransactionService;
import com.jar.transactionmanager.util.CurrencyConverter;
import com.jar.transactionmanager.util.RequestValidator;
import com.jar.transactionmanager.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:16 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */
@Service
public class TransactionService implements ITransactionService {
    @Autowired
    TransactionHistoryRepo transactionHistoryRepo;
    @Autowired
    RequestValidator requestValidator;
    @Autowired
    CurrencyConverter currencyConverter;
    @Autowired
    Utils utils;
    Logger logger = Logger.getLogger(TransactionService.class.getCanonicalName());

    @Override
    public RecordTransactionResponse recordTransaction(String mobileNumber, RecordTransactionRequest recordTransactionRequest) {
        logger.info("In record transaction method");
        requestValidator.validateRecordTransactionRequest(mobileNumber, recordTransactionRequest);
        logger.info("Request Validated Successfully");
        transactionHistoryRepo.save(
                TransactionHistory
                        .builder()
                        .mobileNumber(mobileNumber)
                        .amountInINR(
                                currencyConverter.convertBeforeSaving(
                                        CurrencyEnum.valueOf(recordTransactionRequest.getCurrency()),
                                        recordTransactionRequest.getAmount()
                                )
                        )
                        .transactionType(recordTransactionRequest.getTransactionType().toUpperCase())
                        .transactionCurrency(recordTransactionRequest.getCurrency())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );
        logger.info("Transaction recorded successfully");
        return RecordTransactionResponse
                .builder()
                .isStored(true)
                .build();
    }

    @Override
    public TransactionHistoryResponse getTransactionHistory(String mobileNumber, String fromDate, String toDate, String currency) {
        logger.info("In get Transaction history method");
        requestValidator.validateTransactionHistoryRequest(mobileNumber, fromDate, toDate, currency);
        logger.info("Request validated successfully");
        List<TransactionHistory> fetchedTransactionHistory = transactionHistoryRepo.findByMobileNumberAndCreatedAtBetween(
                mobileNumber,
                utils.getLocalDateTimeForFromDate(fromDate),
                utils.getLocalDateTimeForToDate(toDate)
        );
        logger.info("Transaction fetched successfully, constructing response");
        return utils.constructTransactionHistoryResponse(fetchedTransactionHistory, currency, fromDate, toDate, mobileNumber);
    }
}
