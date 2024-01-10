package com.jar.transactionmanager.util;

import com.jar.transactionmanager.documents.TransactionHistory;
import com.jar.transactionmanager.objects.enums.CurrencyEnum;
import com.jar.transactionmanager.objects.response.TransactionHistoryResponse;
import com.jar.transactionmanager.objects.response.TransactionHistoryResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 7:48 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Component
public class Utils {

    @Autowired
    CurrencyConverter currencyConverter;

    public LocalDateTime getLocalDateTimeForFromDate(String fromDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.of(LocalDate.parse(fromDate, formatter), LocalTime.MIN);
    }

    public LocalDateTime getLocalDateTimeForToDate(String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.of(LocalDate.parse(toDate, formatter), LocalTime.MAX);
    }

    public TransactionHistoryResponse constructTransactionHistoryResponse(
            List<TransactionHistory> fetchedTransactionHistory,
            String currency,
            String fromDate,
            String toDate,
            String mobileNumber) {

        TransactionHistoryResponse transactionHistoryResponse = TransactionHistoryResponse
                .builder()
                .fromDate(fromDate)
                .toDate(toDate)
                .mobileNumber(mobileNumber)
                .transactionHistory(new ArrayList<>())
                .build();
        Double usdToInrValue = (currency == null || currency.toUpperCase().equals(CurrencyEnum.INR.toString()))? 1D : currencyConverter.getUSDToINRValue();
        String finalCurrency = (currency == null)? CurrencyEnum.INR.toString() : currency.toUpperCase();
        for (TransactionHistory transactionHistory : fetchedTransactionHistory) {
            transactionHistoryResponse.getTransactionHistory().add(
                    TransactionHistoryResponseHelper
                            .builder()
                            .transactionId(transactionHistory.getTransactionId())
                            .amount(getAmountAfterConversion(transactionHistory.getAmountInINR(), usdToInrValue))
                            .amountCurrency(finalCurrency)
                            .transactionType(transactionHistory.getTransactionType())
                            .transactionCurrency(transactionHistory.getTransactionCurrency())
                            .transactionDateTime(transactionHistory.getCreatedAt())
                            .build()
            );
        }
        return transactionHistoryResponse;
    }

    private Double getAmountAfterConversion(Double amount, Double usdToInrValue){
        return currencyConverter.convertINRToUSD(amount, usdToInrValue);
    }
}
