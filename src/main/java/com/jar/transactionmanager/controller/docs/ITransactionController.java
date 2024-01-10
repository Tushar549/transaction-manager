package com.jar.transactionmanager.controller.docs;

import com.jar.transactionmanager.objects.GlobalApiResponse;
import com.jar.transactionmanager.objects.constants.Endpoints;
import com.jar.transactionmanager.objects.constants.StringConstants;
import com.jar.transactionmanager.objects.requests.RecordTransactionRequest;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:16 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */
public interface ITransactionController {

    /**
     *
     * @param mobileNumber - MobileNumber of the user for whom the transaction has to be recorded, valid value - 10 digit number
     * @param recordTransactionRequest
     * @return
     */
    @PostMapping(Endpoints.RECORD_TRANSACTION)
    public ResponseEntity<GlobalApiResponse> recordTransaction(
            @ApiParam(example =  StringConstants.MOBILE_NUMBER_DEFAULT_VALUE) @RequestHeader String mobileNumber,
            @RequestBody RecordTransactionRequest recordTransactionRequest
    );

    /**
     *
     * @param mobileNumber
     * @param fromDate - format (yyyy-MM-dd), date from which the transactions needs to be fetched
     * @param toDate - format (yyyy-MM-dd), date up-to which the transactions needs to be fetched
     * @param currency - Valid value (INR/USD) - Currency in which, the transactions needs to be fetched
     * @return
     */
    @GetMapping(Endpoints.GET_TRANSACTION_HISTORY)
    public ResponseEntity<GlobalApiResponse> getTransactionHistory(
            @ApiParam(example =  StringConstants.MOBILE_NUMBER_DEFAULT_VALUE) @RequestHeader(required = false) String mobileNumber,
            @ApiParam(example = StringConstants.FROM_DATE_DEFAULT_VALUE)      @RequestParam(required = false)  String fromDate,
            @ApiParam(example = StringConstants.TO_DATE_DEFAULT_VALUE)        @RequestParam(required = false)  String toDate,
            @ApiParam(example = StringConstants.CURRENCY_DEFAULT_VALUE)       @RequestParam(required = false)  String currency
    );

}
