package com.jar.transactionmanager.util;

import com.jar.transactionmanager.exception.ApplicationException;
import com.jar.transactionmanager.objects.constants.ErrorCodes;
import com.jar.transactionmanager.objects.enums.CurrencyEnum;
import com.jar.transactionmanager.objects.enums.TransactionTypeEnum;
import com.jar.transactionmanager.objects.requests.RecordTransactionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 3:33 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Component
public class RequestValidator {

    public void validateRecordTransactionRequest(String mobileNumber, RecordTransactionRequest recordTransactionRequest) {
        validateMobileNumber(mobileNumber);
        validateTransactionType(recordTransactionRequest.getTransactionType());
        validateCurrency(recordTransactionRequest.getCurrency());
        validateAmount(recordTransactionRequest.getAmount());
    }

    public void validateTransactionHistoryRequest(String mobileNumber, String fromDate, String toDate, String currency) {
        validateMobileNumber(mobileNumber);
        validateDate(fromDate, ErrorCodes.INVALID_FROM_DATE);
        validateDate(toDate, ErrorCodes.INVALID_TO_DATE);
        if (currency != null) {
            validateCurrency(currency);
        }
    }

    private void validateMobileNumber(String mobileNumber) {
        if (mobileNumber == null) {
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.INVALID_MOBILE_NUMBER.getErrorCode())
                    .errorMessage(ErrorCodes.INVALID_MOBILE_NUMBER.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
        String mobileNumberRegex = "^[6-9]{1}[0-9]{9}$";
        Pattern pattern = Pattern.compile(mobileNumberRegex, Pattern.CASE_INSENSITIVE);
        Matcher mather = pattern.matcher(mobileNumber);
        if (!mather.matches()) {
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.INVALID_MOBILE_NUMBER.getErrorCode())
                    .errorMessage(ErrorCodes.INVALID_MOBILE_NUMBER.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    private void validateCurrency(String currency) {
        if(currency == null){
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.INVALID_CURRENCY.getErrorCode())
                    .errorMessage(ErrorCodes.INVALID_CURRENCY.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
        try {
            CurrencyEnum.valueOf(currency);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.INVALID_CURRENCY.getErrorCode())
                    .errorMessage(ErrorCodes.INVALID_CURRENCY.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    private void validateTransactionType(String transactionType) {
        if(transactionType == null){
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.INVALID_TRANSACTION_TYPE.getErrorCode())
                    .errorMessage(ErrorCodes.INVALID_TRANSACTION_TYPE.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
        try {
            TransactionTypeEnum.valueOf(transactionType.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.INVALID_TRANSACTION_TYPE.getErrorCode())
                    .errorMessage(ErrorCodes.INVALID_TRANSACTION_TYPE.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    private void validateAmount(Double amount) {
        if (amount == null || amount <= 0D) {
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.INVALID_AMOUNT.getErrorCode())
                    .errorMessage(ErrorCodes.INVALID_AMOUNT.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    private void validateDate(String date, ErrorCodes errorCode) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (date == null) {
            throw ApplicationException
                    .builder()
                    .errorCode(errorCode.getErrorCode())
                    .errorMessage(errorCode.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }

        try {
            format.parse(date);
        } catch (DateTimeParseException dateTimeParseException) {
            throw ApplicationException
                    .builder()
                    .errorCode(errorCode.getErrorCode())
                    .errorMessage(errorCode.getDescription())
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

}
